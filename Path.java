import java.util.LinkedList;

/**
 * Path objects store a discovered path of vertices and the overal distance of cost of the weighted
 * directed edges along this path. Path objects can be copied and extended to include new edges and
 * verticies using the extend constructor. In comparison to a predecessor table which is sometimes
 * used to implement Dijkstra's algorithm, this eliminates the need for tracing paths backwards
 * from the destination vertex to the starting vertex at the end of the algorithm.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Path implements IPath, Comparable<Path> {
    public CS400Graph.Vertex start; // first vertex within path
    public double time; // sumed weight of all edges in path
    public LinkedList dataSequence; // ordered sequence of data from vertices in path
    public CS400Graph.Vertex end; // last vertex within path

    /**
     * Creates a new path containing a single vertex. Since this vertex is both the start and end of
     * the path, it's initial distance is zero.
     *
     * @param start is the first vertex on this path
     */
    public Path(CS400Graph.Vertex start) {
        this.start = start;
        this.time = 0.0;
        this.dataSequence = new LinkedList<>();
        this.dataSequence.add(start.data);
        this.end = start;
    }

    /**
     * This extension constructor makes a copy of the path passed into it as an argument without
     * affecting the original path object (copyPath). The path is then extended by the Edge object
     * extendBy. Use the doubleValue() method of extendBy's weight field to get a double
     * representation of the edge's weight.
     *
     * @param copyPath is the path that is being copied
     * @param extendBy is the edge the copied path is extended by
     */
    public Path(Path copyPath, CS400Graph.Edge extendBy) {
        // Set start of new path
        this.start = copyPath.start;

        // New distance
        this.time = copyPath.time + extendBy.weight.doubleValue();

        // Deep copy list
        this.dataSequence = new LinkedList<>();
        for (Object n : copyPath.dataSequence) {
            this.dataSequence.add(n);
        }
        // Add edge extension
        this.dataSequence.add(extendBy.target.data);

        // Set end of path
        this.end = extendBy.target;
    }

    /**
     * Allows the natural ordering of paths to be increasing with path distance. When path distance
     * is equal, the string comparison of end vertex data is used to break ties.
     *
     * @param other is the other path that is being compared to this one
     * @return -1 when this path has a smaller distance than the other, +1 when this path has a
     * larger distance that the other, and the comparison of end vertex data in string form when
     * these distances are tied
     */
    public int compareTo(Path other) {
        int cmp = Double.compare(this.time, other.time);
        if (cmp != 0)
            return cmp; // use path distance as the natural ordering
        // when path distances are equal, break ties by comparing the string
        // representation of data in the end vertex of each path
        return this.end.data.toString().compareTo(other.end.data.toString());
    }

    @Override
    public LinkedList getPath() {
        // return datasequence
        return this.dataSequence;
    }

    @Override
    public double getCost() {
        // return time
        return this.time;
    }
}
