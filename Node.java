// --== CS400 File Header Information ==--
// Name: Riya Kore
// Email: rykore@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian Heimrl
// Notes to Grader: None

/**
 * This class implements the INode interface which helps you get the Start Location Node,
 * the End Location Node, and the time required to reach the End Node from its shortest path.
 */
public class Node implements INode {

    String startLocation;

    String endLocation;

    int travelTime;

    public Node(String startLocation, String endLocation, int travelTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.travelTime = travelTime;
    }

    /**
     * This method is used to get the name of the starting Node
     * @return the name of the starting node
     */
    @Override
    public String getStartLocation() {
        return this.startLocation;
    }

    /**
     * This method is used to get the name of the Ending/ Destination Node
     * @return the name of the ending node
     */
    @Override
    public String getEndLocation() {
        return this.endLocation;
    }

    /**
     * This method returns the travel time from the start Location to the end location
     * taking its shortest path
     * @return the amount of time required to reach the end location from the shortest path
     */
    @Override
    public int getTravelTime() {
        return this.travelTime;
    }
}

