import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;

import java.util.NoSuchElementException;

public class BDGraph<NodeType, EdgeType extends Number> implements BDGraphADT<NodeType, EdgeType> {

    /**
     * Vertex objects group a data field with an adjacency list of weighted
     * directed edges that lead away from them.
     */
    protected class Vertex {
        public NodeType data; // vertex label or application specific data
        public LinkedList<Edge> edgesLeaving;

        public Vertex(NodeType data) {
            this.data = data;
            this.edgesLeaving = new LinkedList<>();
        }
    }

    /**
     * Edge objects are stored within their source vertex, and group together
     * their target destination vertex, along with an integer weight.
     */
    protected class Edge {
        public Vertex target;
        public EdgeType weight;

        public Edge(Vertex target, EdgeType weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    protected Hashtable<NodeType, Vertex> vertices; // holds graph vertices, key=data

    public BDGraph() {
        vertices = new Hashtable<>();
    }

    /**
     * Insert a new vertex into the graph.
     *
     * @param data the data item stored in the new vertex
     * @return true if the data can be inserted as a new vertex, false if it is
     *         already in the graph
     * @throws NullPointerException if data is null
     */
    public boolean insertVertex(NodeType data) {
        if (data == null)
            throw new NullPointerException("Cannot add null vertex");
        if (vertices.containsKey(data))
            return false; // duplicate values are not allowed
        vertices.put(data, new Vertex(data));
        return true;
    }

    /**
     * Remove a vertex from the graph.
     * Also removes all edges adjacent to the vertex from the graph (all edges
     * that have the vertex as a source or a destination vertex).
     *
     * @param data the data item stored in the vertex to remove
     * @return true if a vertex with *data* has been removed, false if it was not in
     *         the graph
     * @throws NullPointerException if data is null
     */
    public boolean removeVertex(NodeType data) {
        if (data == null)
            throw new NullPointerException("Cannot remove null vertex");
        Vertex removeVertex = vertices.get(data);
        if (removeVertex == null)
            return false; // vertex not found within graph
        // search all vertices for edges targeting removeVertex
        for (Vertex v : vertices.values()) {
            Edge removeEdge = null;
            for (Edge e : v.edgesLeaving)
                if (e.target == removeVertex)
                    removeEdge = e;
            // and remove any such edges that are found
            if (removeEdge != null)
                v.edgesLeaving.remove(removeEdge);
        }
        // finally remove the vertex and all edges contained within it
        return vertices.remove(data) != null;
    }

    /**
     * Insert a new directed edge with a positive edge weight into the graph.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @param weight the weight for the edge (has to be a positive integer)
     * @return true if the edge could be inserted or its weight updated, false
     *         if the edge with the same weight was already in the graph
     * @throws IllegalArgumentException if either source or target or both are not
     *                                  in the graph,
     *                                  or if its weight is < 0
     * @throws NullPointerException     if either source or target or both are null
     */
    public boolean insertEdge(NodeType source, NodeType target, EdgeType weight) {
        if (source == null || target == null)
            throw new NullPointerException("Cannot add edge with null source or target");
        Vertex sourceVertex = this.vertices.get(source);
        Vertex targetVertex = this.vertices.get(target);
        if (sourceVertex == null || targetVertex == null)
            throw new IllegalArgumentException("Cannot add edge with vertices that do not exist");
        if (weight.doubleValue() < 0)
            throw new IllegalArgumentException("Cannot add edge with negative weight");
        // handle cases where edge already exists between these verticies
        for (Edge e : sourceVertex.edgesLeaving)
            if (e.target == targetVertex) {
                if (e.weight.doubleValue() == weight.doubleValue())
                    return false; // edge already exists
                else
                    e.weight = weight; // otherwise update weight of existing edge
                return true;
            }
        // otherwise add new edge to sourceVertex
        sourceVertex.edgesLeaving.add(new Edge(targetVertex, weight));
        return true;
    }

    /**
     * Remove an edge from the graph.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @return true if the edge could be removed, false if it was not in the graph
     * @throws IllegalArgumentException if either source or target or both are not
     *                                  in the graph
     * @throws NullPointerException     if either source or target or both are null
     */
    public boolean removeEdge(NodeType source, NodeType target) {
        if (source == null || target == null)
            throw new NullPointerException("Cannot remove edge with null source or target");
        Vertex sourceVertex = this.vertices.get(source);
        Vertex targetVertex = this.vertices.get(target);
        if (sourceVertex == null || targetVertex == null)
            throw new IllegalArgumentException("Cannot remove edge with vertices that do not exist");
        // find edge to remove
        Edge removeEdge = null;
        for (Edge e : sourceVertex.edgesLeaving)
            if (e.target == targetVertex)
                removeEdge = e;
        if (removeEdge != null) { // remove edge that is successfully found
            sourceVertex.edgesLeaving.remove(removeEdge);
            return true;
        }
        return false; // otherwise return false to indicate failure to find
    }

    /**
     * Check if the graph contains a vertex with data item *data*.
     *
     * @param data the data item to check for
     * @return true if data item is stored in a vertex of the graph, false otherwise
     * @throws NullPointerException if *data* is null
     */
    public boolean containsVertex(NodeType data) {
        if (data == null)
            throw new NullPointerException("Cannot contain null data vertex");
        return vertices.containsKey(data);
    }

    /**
     * Check if edge is in the graph.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @return true if the edge is in the graph, false if it is not in the graph
     * @throws NullPointerException if either source or target or both are null
     */
    public boolean containsEdge(NodeType source, NodeType target) {
        if (source == null || target == null)
            throw new NullPointerException("Cannot contain edge adjacent to null data");
        Vertex sourceVertex = vertices.get(source);
        Vertex targetVertex = vertices.get(target);
        if (sourceVertex == null)
            return false;
        for (Edge e : sourceVertex.edgesLeaving)
            if (e.target == targetVertex)
                return true;
        return false;
    }

    /**
     * Return the weight of an edge.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @return the weight of the edge (a Number that represents 0 or a positive
     *         value)
     * @throws IllegalArgumentException if either sourceVertex or targetVertex or
     *                                  both are not in the graph
     * @throws NullPointerException     if either sourceVertex or targetVertex or
     *                                  both are null
     * @throws NoSuchElementException   if edge is not in the graph
     */
    public EdgeType getWeight(NodeType source, NodeType target) {
        if (source == null || target == null)
            throw new NullPointerException("Cannot contain weighted edge adjacent to null data");
        Vertex sourceVertex = vertices.get(source);
        Vertex targetVertex = vertices.get(target);
        if (sourceVertex == null || targetVertex == null)
            throw new IllegalArgumentException("Cannot retrieve weight of edge between vertices that do not exist");
        for (Edge e : sourceVertex.edgesLeaving)
            if (e.target == targetVertex)
                return e.weight;
        throw new NoSuchElementException("No directed edge found between these vertices");
    }

    /**
     * Return the number of edges in the graph.
     *
     * @return the number of edges in the graph
     */
    public int getEdgeCount() {
        int edgeCount = 0;
        for (Vertex v : vertices.values())
            edgeCount += v.edgesLeaving.size();
        return edgeCount;
    }

    /**
     * Return the number of vertices in the graph
     *
     * @return the number of vertices in the graph
     */
    public int getVertexCount() {
        return vertices.size();
    }

    /**
     * Check if the graph is empty (does not contain any vertices or edges).
     *
     * @return true if the graph does not contain any vertices or edges, false
     *         otherwise
     */
    public boolean isEmpty() {
        return vertices.size() == 0;
    }

    /**
     * Returns the shortest path between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     *
     * @param start the data item in the starting vertex for the path
     * @param end   the data item in the destination vertex for the path
     * @return list of data item in vertices in order on the shortest path between
     *         vertex
     *         with data item start and vertex with data item end, including both
     *         start and end
     * @throws NoSuchElementException when no path from start to end can be found
     *                                including when no vertex containing start or
     *                                end can be found
     */
    public List<NodeType> shortestPath(NodeType start, NodeType end) {
        return null;
    }

    /**
     * Returns the cost of the path (sum over edge weights) between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     *
     * @param start the data item in the starting vertex for the path
     * @param end   the data item in the end vertex for the path
     * @return the cost of the shortest path between vertex with data item start
     *         and vertex with data item end, including all edges between start and
     *         end
     * @throws NoSuchElementException when no path from start to end can be found
     *                                including when no vertex containing start or
     *                                end can be found
     */
    public double getPathCost(NodeType start, NodeType end) {
        return 0;
    }

}
