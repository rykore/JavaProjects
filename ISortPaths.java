//-== CS400 Project 3 File Header ==-
// Red Team: Sam Katerov
// Blue Team: Ayden Visser
// Lecture: 003 @ 2:25pm

public interface ISortPaths {

    /**
     * This method returns an array of Path objects, with the fastest path at index 0.
     *
     * @param unsorted Unsorted array of paths
     * @return Sorted array of paths
     */
    public Path[] sort(Path[] unsorted);

    /**
     * This method returns a single Path that has the lowest cost.
     *
     * @param unsorted Unsorted array of paths
     * @return The shortest path amongst the input array
     */
    public Path shortestPath(Path[] unsorted);

    /**
     * This method returns a single Path that traverses the fewest buildings (nodes).
     *
     * @param unsorted Unsorted array of paths
     * @return The path with the fewest nodes amongst the input array
     */
    public Path fewestDoors(Path[] unsorted);
}
