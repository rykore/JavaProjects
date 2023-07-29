// --== CS400 File Header Information ==--
// Name: Karam Dilip Gursahani
// Email: kdgursahani@wisc.edu
// Team: EB
// TA: Sujitha Perumal
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.util.LinkedList;

/**
 * This is placeholder class for the SortPaths class to be created by BD.
 *
 * @author karam
 *
 */
public class DummySortPaths {

    private static DummyPath[] paths = new DummyPath[2];

    /**
     * This is a constructor method for the placeholder class SortPaths, it creates a dummy list of
     * two nodes each time.
     */
    public DummySortPaths() {
        FDNode memU = new FDNode("A");
        FDNode eHall = new FDNode("C");
        FDNode gRoot = new FDNode("D");


        LinkedList<FDNode> pathOneLL = new LinkedList<>();
        pathOneLL.add(memU);
        pathOneLL.add(gRoot);

        DummyPath pathOne = new DummyPath(pathOneLL, 5);

        LinkedList<FDNode> pathTwoLL = new LinkedList<>();
        pathTwoLL.add(eHall);
        pathTwoLL.add(memU);
        pathTwoLL.add(gRoot);

        DummyPath pathTwo = new DummyPath(pathTwoLL, 11);

        paths[0] = pathOne;
        paths[1] = pathTwo;

    }
    /**
     * This method returns an array of Path objects, with the fastest path at index 0.
     */
    public static DummyPath[] sort() {
        return paths;
    }

    /**
     * This method returns a single Dummy Path that has the lowest cost.
     */
    public DummyPath shortestPath() {
        return paths[0];
    }

    /**
     * This method returns a single Dummy Path that traverses the fewest buildings (nodes).
     */
    public DummyPath fewestDoors() {
        return paths[1];
    }

}
