// --== CS400 Fall 2022 File Header Information ==--
// Name: Smit Vasani
// Email: svasani@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: NONE

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Used to parse the information provided by the Data Wrangler
 */
public class Parser {
    static CS400Graph<String, Integer> parsedMap = new CS400Graph<>();

    /**
     * Makes a graph from the given data of list of nodes
     * @param nodeList List of nodes each with a start point, end point and the distance
     * @return a graph with edges and vertices as described by the Node objects.
     */
    public static CS400Graph<String, Integer> parseNodes(List<Node> nodeList) {
        Set<String> locations = new HashSet<>();
        for (int i = 0; i < nodeList.size(); ++i) {
            locations.add(nodeList.get(i).getStartLocation());
            locations.add(nodeList.get(i).getEndLocation());
        }
        String [] loc = locations.toArray(new String[0]);
        for (int j = 0; j < loc.length; ++j) {
            parsedMap.insertVertex(loc[j]);
        }
        for (int k = 0; k < nodeList.size(); ++k) {
            parsedMap.insertEdge(nodeList.get(k).getStartLocation(), nodeList.get(k).getEndLocation(),
                    nodeList.get(k).getTravelTime());
        }
        return parsedMap;
    }


}
