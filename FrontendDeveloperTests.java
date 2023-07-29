// --== CS400 File Header Information ==--
// Name: Karam Dilip Gursahani
// Email: kdgursahani@wisc.edu
// Team: EB
// TA: Sujitha Perumal
// Lecturer:  Florian Heimerl
// Notes to Grader: <optional extra notes>

/*** JUnit imports ***/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // Do NOT use org.junit.Test, will cause BeforeEach to error out!
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class runs the tests associated with the Frontend Developer's Code
 * @author karam
 *
 */
public class FrontendDeveloperTests {

    protected TextUITester tester = null;
    protected CampusMapperFrontend frontEnd = null;
    protected String output;

    /**
     * Creates an instance of the frontend of the application before each test.
     */
    @BeforeEach
    public void createInstance() {

        frontEnd = new CampusMapperFrontend();

    }
    /**
     * This method tests to see that the program reacts correctly when fed fewest doors argument
     */
    @Test
    public void validOnThree() {

        tester = new TextUITester("3\n\nEXIT\n");
        frontEnd.runCommandLoop();
        output = tester.checkOutput();
        assertTrue(output.contains("The path with the fewest doors is C - A - D"));

    }

    /**
     * This method tests to see that the program reacts correctly when fed shortest path argument
     */
    @Test
    public void validOnOne() {

        tester = new TextUITester("1\n\nEXIT\n");
        frontEnd.runCommandLoop();
        output = tester.checkOutput();
        assertTrue(output.contains("The shortest path is A - D"));
        System.out.println(output);
    }
    /**
     * This method tests to see that the program reacts correctly when fed all paths argument
     */
    @Test
    public void validOnTwo() {

        tester = new TextUITester("2\n\nEXIT\n");
        frontEnd.runCommandLoop();
        output = tester.checkOutput();
        assertTrue(output.contains(
                "These are the paths you could take with the time required to traverse them: A - D: 5 minutes| C - A - D: 11 minutes|"));
    }

    /**
     * This method tests to see that the program reacts correctly when fed an invalid argument
     */
    @Test
    public void invalid() {

        tester = new TextUITester("45\n\nEXIT\n");
        frontEnd.runCommandLoop();
        output = tester.checkOutput();
        assertTrue(output.contains("That is not a valid option, you should either select 1,2, or 3."));

    }
//

    /**
     * This method tests to see that the program reacts correctly when the user requests to exit
     */
    @Test
    public void exit() {

        tester = new TextUITester("2\n\n1\n\n3\n\nEXIT\n");
        frontEnd.runCommandLoop();
        output = tester.checkOutput();
        assertTrue(output.contains("Goodbye!"));

    }
}

