// --== CS400 File Header Information ==--
// Name: Karam Dilip Gursahani
// Email: kdgursahani@wisc.edu
// Team: EB
// TA: Sujitha Perumal
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * This is a placeholder class for the Node class to be constructed by BD.
 *
 * @author karam
 *
 */
public class FDNode {

    private String name;

    /**
     * This is a constuctor method for a dummy node.
     *
     * @param campusLocation
     */
    public FDNode(String campusLocation) {
        name = campusLocation;
    }

    /**
     * This method returns the campus location as a string.
     *
     * @return
     */
    public String getCampusLocation() {
        return this.name;
    }
}

