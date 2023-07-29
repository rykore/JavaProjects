// --== CS400 Project Three File Header ==--
// Name: Karam Gursahani Frontend Developer
// CSL Username: karam
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: None

/**
 * This interface consists of the methods required to execute the user-interface of the Campus
 * Visitor Walktime Guide
 *
 * @author karam
 *
 */
public interface ICampusMapperFrontend {

    /**
     * This method starts the command loop for the user interface, and will terminate once the desired
     * output is displayed to the user
     */
    public void runCommandLoop();

    /**
     * Displays the main menu
     */
    public void displayMainMenu();

    /**
     * Displays the shortest path the user would have to take
     */
    public void displayShortestPath();

    /**
     * Displays all the possible paths the user could take, sorted from shortest to longest
     */
    public void displayAllPaths();

    /**
     * Displays the path with the fewest doors path (least nodes traversed)
     */
    public void displayFewestDoorsPath();


}

