//-== CS400 Project 3 File Header ==-
// Red Team: Sam Katerov
// Blue Team: Ayden Visser
// Lecture: 003 @ 2:25pm

import java.util.LinkedList;

@SuppressWarnings("rawtypes")
public interface IPath {

    /**
     * This method returns the path stored in the Path object represented as a LinkedList
     *
     * @return The path of this path
     */
    public LinkedList getPath();

    /**
     * This method returns the total cost of the path
     *
     * @return The cost of this path
     */
    public double getCost();

}
