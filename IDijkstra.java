// --== CS400 Fall 2022 File Header Information ==--
// Name: Smit Vasani
// Email: svasani@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: NONE

/**
 * Instances of this interface define a single method used to find the shortest path between a fixed point and the
 * given endpoint.
 * @param <T> Generic parameter
 */
public interface IDijkstra<T> {

    /**
     * Finds the shortest path and returns an array of nodes that lie in this path for a fixed starting point and the
     * given endpoint.
     *
     * @param endpoint End point of the path
     * @return An array of nodes that lie between the start point and the end point.
     */
    public String[] makePath(String endpoint);
}

