// --== CS400 Fall 2022 File Header Information ==--
// Name: Smit Vasani
// Email: svasani@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: NONE

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

/**
 * Applies Dijkstra's algorithm to get the shortest path between two points.
 * @param <T> Generic Parameter
 * @param <E> Generic Parameter that extends Number class
 */
public class Dijkstra<T, E extends Number> extends CS400Graph implements IDijkstra {
    private final String START = "CSBuilding";
    public static CampusMatrix data = new CampusMatrix();
    static String fileName = "CampusNode.dot";
    private static final List<Node> dataList;
    static {
        try {
            dataList = data.loadMatrix(fileName);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static CS400Graph<String, Integer> genMap = Parser.parseNodes(dataList);

    /**
     * Find the shortest path between CS Building and user provided end point.
     * @param end End point of the path
     * @return String array with locations in order they should be visited so that the path is shortest.
     */
    @Override
    public String[] makePath(String end) {
        String endNode = end;

        List<String> seq = genMap.dijkstrasShortestPath(START,endNode).dataSequence;
        Iterator<String> seqIterator = seq.listIterator();
        String[] finPath = new String[seq.size()];

        int i = 0;
        while(seqIterator.hasNext()) {
            finPath[i] = seqIterator.next();
            ++i;
        }
        return finPath;
    }

    /**
     * Gives the shortest distance between CS Building and user provided ned point.
     * @param end end point of the path.
     * @return shortest distance between CS Building and user provided ned point.
     */
    public double getTravelTime(String end) {
        return genMap.dijkstrasShortestPath("CSBuilding", end).time;
    }

}
