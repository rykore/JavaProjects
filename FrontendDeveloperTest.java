// --== CS400 Project One File Header ==--
// Name: Smit Vasani
// CSL Username: smit
// Email: svasani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: NONE

import java.util.Scanner;

/**
 * Tests the functionality of all the methods defined in BookMapperFrontend class.
 */
public class FrontendDeveloperTest {

    /**
     * Checks for the functionality for user input = 4
     * @return True if the output matches the expected value, False otherwise.
     */
    public static boolean test1() {
        TextUITester tester = new TextUITester("4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();

        String output = tester.checkOutput();

        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";
        if (!output.equals(expected)) {
            return false;
        }

        return true;
    }

    /**
     * Checks for the functionality for user input = 1
     * @return True if the output matches the expected value, False otherwise.
     */
    public static boolean test2() {
        TextUITester tester = new TextUITester("1\n123\n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();

        String output = tester.checkOutput();

        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "1\n"
                + "You are in the Lookup ISBN Menu:\n"
                + "          Enter ISBN to look up: 123\n" + "1. \"Title 1\" by Author1, Author2, ISBN: 123\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";

        if(!output.equals(expected)) {
            return false;
        }
        return true;
    }

    /**
     * Checks for the functionality of the methods for user input = 2
     * @return True if the output matches the expected value, False otherwise.
     */
    public static boolean test3() {
        TextUITester tester = new TextUITester("2\nhello\n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();

        String output = tester.checkOutput();

        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "2\n"
                + "You are in the Search for Title Word Menu:\n"
                + "          Enter a word to search for in book titles (empty for all books): "
                + "Matches (author filter: null) 2 of 2\n"+"1. \"Title 1\" by Author1, Author2, ISBN: 2375930165723\n\n"
                + "2. \"Title 2\" by Author3, Author4, ISBN: 8582963137254\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";

        if(!output.equals(expected)){
            System.out.println(expected);
            return false;
        }
        return true;
    }

    /**
     * Checks for the functionality of methods for user input = 3
     * @return True if the output matches the expected value, False otherwise.
     */
    public static boolean test4() {
        TextUITester tester = new TextUITester("3\nSmit\n3\n\n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();
        String output = tester.checkOutput();
        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "3\n"
                + "You are in the Set Author Filter Menu:\n" + "          Author name must currently contain: null\n"
                + "          Enter a new string for author names to contain (empty for any): Smit\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "3\n"
                + "You are in the Set Author Filter Menu:\n" + "          Author name must currently contain: Smit\n"
                + "          Enter a new string for author names to contain (empty for any): \n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";

        if (!output.equals(expected)) {
            return false;
        }
        return true;
    }

    /**
     * Checks for the functionality of methods when invalid or void inputs are passed.
     * @return True if the output matches the expected value, False otherwise.
     */
    public static boolean test5() {
        TextUITester tester = new TextUITester("6\nf\n 1\n9827\n \n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();
        String output = tester.checkOutput();

        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "6\n"
                +  "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "f\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "1\n"
                + "You are in the Lookup ISBN Menu:\n" + "          Enter ISBN to look up: 987\n"
                + "1. \"Title 1\" by Author1, Author2, ISBN: 987\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";

        if(!output.equals(expected)) {
            return false;
        }
        return true;
    }

    public static boolean FrontendDeveloperTest1() {
        TextUITester tester = new TextUITester("1\n321\n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();

        String output = tester.checkOutput();

        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "1\n"
                + "You are in the Lookup ISBN Menu:\n"
                + "          Enter ISBN to look up: 321\n" + "1. \"Title 1\" by Author1, Author2, ISBN: 321\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";

        if(!output.equals(expected)) {
            return false;
        }
        return true;
    }

    public static boolean FrontendDeveloperTest2() {
        TextUITester tester = new TextUITester("pqr\n9\n 1\n123\n \n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();
        String output = tester.checkOutput();

        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "pqr\n"
                +  "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "9\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "1\n"
                + "You are in the Lookup ISBN Menu:\n" + "          Enter ISBN to look up: 123\n"
                + "1. \"Title 1\" by Author1, Author2, ISBN: 123\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";

        if(!output.equals(expected)) {
            return false;
        }

        return true;
    }

    public static boolean IntegrationTest1() {

        TextUITester tester = new TextUITester("uvw\n3\nRedTeam\n3\n\n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();
        String output = tester.checkOutput();
        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "uvw\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "3\n"
                + "You are in the Set Author Filter Menu:\n" + "          Author name must currently contain: null\n"
                + "          Enter a new string for author names to contain (empty for any): RedTeam\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "3\n"
                + "You are in the Set Author Filter Menu:\n" + "          Author name must currently contain: RedTeam\n"
                + "          Enter a new string for author names to contain (empty for any): \n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";

        if (!output.equals(expected)) {
            return false;
        }
        return true;
    }

    public static boolean IntegrationTest2() {

        TextUITester tester = new TextUITester("\n\n4\n");

        Scanner reader = new Scanner(System.in);
        BookMapperBackend backend = new BookMapperBackend();
        ISBNValidator validator = new ISBNValidator();
        BookMapperFrontend frontend = new BookMapperFrontend(reader, backend, validator);

        frontend.runCommandLoop();

        String output = tester.checkOutput();

        String expected = "Welcome to the Book Mapper Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"
                + "You are in the Main Menu:\n" + "          1) Lookup ISBN\n" + "          2) Search by Title Word\n"
                + "          3) Set Author Name Filter\n" + "          4) Exit Application\n" + "4\n";
        if (!output.equals(expected)) {
            return false;
        }

        return true;
    }
    /**
     * Main function of the class to run all the tests.
     * @param args args if any.
     */
    public static void main (String [] args) {

        System.out.println("Frontend Developer Test 1: " + test1());
        System.out.println("Frontend Developer Test 2: " + test2());
        System.out.println("Frontend Developer Test 3: " + test3());
        System.out.println("Frontend Developer Test 4: " + test4());
        System.out.println("Frontend Developer Test 5:" + test5());
        System.out.println("Data Wrangler Integration Test 1: " + IntegrationTest1());
        System.out.println("Data Wrangler Integration Test 2: " + IntegrationTest2());
        System.out.println("Sam Katerov (Data Wrangler) Test 1: " + FrontendDeveloperTest1());
        System.out.println("Sam Katerov (Data Wrangler) Test 2: " + FrontendDeveloperTest2());
    }
}