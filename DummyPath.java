// --== CS400 File Header Information ==--
// Name: Karam Dilip Gursahani
// Email: kdgursahani@wisc.edu
// Team: EB
// TA: Sujitha Perumal
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.util.LinkedList;

/**
 * This is a placeholder class for the Path class to be constructed by BD.
 *
 * @author karam
 *
 */
public class DummyPath {

    private LinkedList<FDNode> path;
    private int time;

    /**
     * This is a constructor method for a dummy path that takes a linked list and the cost as
     * parameters
     *
     * @param path - the path as a linked list of FDNodes
     * @param cost - the cost associated with the "dummy" path
     */
    public DummyPath(LinkedList<FDNode> path, int cost) {

        this.path = path;
        this.time = cost;

    }
    /**
     * This method returns the linked list for the dummy path.
     *
     * @return
     */
    public LinkedList<FDNode> getPath() {
        return this.path;
    }

    /**
     * This method returns the cost associated with the dummy path.
     *
     * @return
     */
    public int getTime() {
        return this.time;
    }


}

