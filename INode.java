// --== CS400 File Header Information ==--
// Name: Riya Kore
// Email: rykore@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian Heimrl
// Notes to Grader: None

/**
 * This interface has the getter methods to get the start location, the end location and the
 * travel time to reach a particular destination from a starting location.
 */
public interface INode {

    /**
     * This method is used to get the name of the Starting Location
     * @return the name of the starting location
     */
    public String getStartLocation();

    /**
     * This method is used to get the name of thr Ending Location
     * @return the name of the ending location
     */
    public String getEndLocation();

    /**
     * This method is used to get the travel time from a starting point to an ending point
     * @return the travel time
     */
    public int getTravelTime();
}

