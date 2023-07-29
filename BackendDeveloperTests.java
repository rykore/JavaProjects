import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class BackendDeveloperTests {

    private CS400Graph<String, Integer> graph;

    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {

        //directed graph
        graph = new CS400Graph<>();

        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");

        // insert edges
        graph.insertEdge("A", "B", 6);
        graph.insertEdge("A", "C", 2);
        graph.insertEdge("A", "D", 5);
        graph.insertEdge("B", "E", 1);
        graph.insertEdge("B", "C", 2);
        graph.insertEdge("C", "B", 3);
        graph.insertEdge("C", "F", 1);
        graph.insertEdge("D", "E", 3);
        graph.insertEdge("E", "A", 4);
        graph.insertEdge("F", "A", 1);
        graph.insertEdge("F", "D", 1);
    }

    /**
     * Tests if paths are constucted properly
     */
    @Test
    public void testPathCreation() {
        Path pathA = new Path(graph.vertices.get("A"));
        LinkedList expected = new LinkedList<>();
        expected.add("A");

        if (pathA.getCost() == 0 && pathA.getPath().equals(expected)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    /**
     * Tests if paths are extended properly
     */
    @Test
    public void testPathExtension() {
        Path pathA = new Path(graph.vertices.get("A"));
        Path pathAB = new Path(pathA, graph.vertices.get("A").edgesLeaving.get(0));
        LinkedList expected = new LinkedList<>();
        expected.add("A");
        expected.add("B");

        if (pathAB.getCost() == 6 && pathAB.getPath().equals(expected)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    /**
     * Tests if paths are sorted properly
     */
    @Test
    public void testSort() {
        Path pathA = new Path(graph.vertices.get("A")); // A, 0
        Path pathAB = new Path(pathA, graph.vertices.get("A").edgesLeaving.get(0)); // AB, 6
        Path pathAC = new Path(pathA, graph.vertices.get("A").edgesLeaving.get(1)); // AC, 2
        Path pathACB = new Path(pathAC, graph.vertices.get("C").edgesLeaving.get(0)); // ACB, 5

        Path pathUnsort[] = new Path[4];
        pathUnsort[0] = pathAC;
        pathUnsort[1] = pathA;
        pathUnsort[2] = pathAB;
        pathUnsort[3] = pathACB;

        Path pathSort[] = new Path[4];
        pathSort[0] = pathA;
        pathSort[1] = pathAC;
        pathSort[2] = pathACB;
        pathSort[3] = pathAB;

        SortPaths sPaths = new SortPaths();
        Path pathDone[] = sPaths.sort(pathUnsort);

        if (Arrays.equals(pathDone, pathSort)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    /**
     * Tests if the shortest path is returned
     */
    @Test
    public void testShortestPath() {
        Path pathA = new Path(graph.vertices.get("A")); // A, 0
        Path pathAB = new Path(pathA, graph.vertices.get("A").edgesLeaving.get(0)); // AB, 6
        Path pathAC = new Path(pathA, graph.vertices.get("A").edgesLeaving.get(1)); // AC, 2
        Path pathACB = new Path(pathAC, graph.vertices.get("C").edgesLeaving.get(0)); // ACB, 5

        Path pathUnsort[] = new Path[4];
        pathUnsort[0] = pathAC;
        pathUnsort[1] = pathA;
        pathUnsort[2] = pathAB;
        pathUnsort[3] = pathACB;

        Path pathSort = pathA;

        SortPaths sPaths = new SortPaths();
        Path pathDone = sPaths.shortestPath(pathUnsort);

        if (pathDone.equals(pathSort)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     * Tests if the path with the fewest nodes is returned
     */
    @Test
    public void testFewestDoors() {
        Path pathA = new Path(graph.vertices.get("A")); // A, 0
        Path pathAB = new Path(pathA, graph.vertices.get("A").edgesLeaving.get(0)); // AB, 6
        Path pathAC = new Path(pathA, graph.vertices.get("A").edgesLeaving.get(1)); // AC, 2
        Path pathACB = new Path(pathAC, graph.vertices.get("C").edgesLeaving.get(0)); // ACB, 5

        Path pathUnsort[] = new Path[3];
        pathUnsort[0] = pathACB;
        pathUnsort[1] = pathAB;
        pathUnsort[2] = pathAC;

        Path pathSort = pathAC;

        SortPaths sPaths = new SortPaths();
        Path pathDone = sPaths.fewestDoors(pathUnsort);

        if (pathDone.equals(pathSort)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
}
