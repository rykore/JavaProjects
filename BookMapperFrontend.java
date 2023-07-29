// --== CS400 Project One File Header ==--
// Name: Smit Vasani
// CSL Username: smit
// Email: svasani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: NONE

import java.util.List;
import java.util.Scanner;

public class BookMapperFrontend implements IBookMapperFrontend{
    Scanner scnr = null;
    IBookMapperBackend backend;
    IISBNValidator validator;

    /**
     * The constructor that the implementation this interface will
     * provide. It takes the Scanner that will read user input as
     * a parameter as well as the backend and the ISBNnalidator.
     */
    public BookMapperFrontend(Scanner userInputScanner, IBookMapperBackend backend, IISBNValidator validator) {
        this.scnr = userInputScanner;
        this.backend = backend;
        this.validator = validator;
    }

    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
    @Override
    public void runCommandLoop() {
        System.out.println("Welcome to the Book Mapper Application!");
        System.out.println("x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x");
        System.out.println();
        displayMainMenu();
        // run the program until the user types 4
        while (true) {

            boolean isValid = false;
            char input = '0';
            String temp;
            // accept inputs from the user until a valid input is received.
            while(isValid != true) {
                temp = scnr.next().trim();
                input = temp.charAt(0);
                if(input == '1' || input == '2' ||input == '3' ||input == '4') {
                    isValid = true;
                    break;
                }
                System.out.println(temp);
                displayMainMenu();
            }
            if (isValid) {
                System.out.println(input);
                int search = Character.getNumericValue(input);
                // stop looping once the user types 4
                if(search == 4) {
                    break;
                }
                // lookup books by the ISBN number that the user inputs.
                else if (search == 1) {
                    isbnLookup();
                }
                // lookup books by the title that the user inputs.
                else if (search == 2) {
                    titleSearch();
                }
                // provide functionality for setting the author filter when user inputs 3
                else if (search == 3) {
                    System.out.println("You are in the Set Author Filter Menu:");
                    System.out.println("          Author name must currently contain: " + backend.getAuthorFilter());
                    System.out.print("          Enter a new string for author names to contain (empty for any): ");
                    scnr.nextLine();
                    String filterByAuthor = scnr.nextLine();
                    if (filterByAuthor != null && !filterByAuthor.isEmpty()) {
                        System.out.print(filterByAuthor);
                        backend.setAuthorFilter(filterByAuthor);
                    }
                    System.out.println();
                    displayMainMenu();
                }
            }

        }
    }

    /**
     * This method displays the menu displaying the options for the user to input.
     */
    @Override
    public void displayMainMenu() {
        System.out.println("You are in the Main Menu:");
        System.out.println("          1) Lookup ISBN");
        System.out.println("          2) Search by Title Word");
        System.out.println("          3) Set Author Name Filter");
        System.out.println("          4) Exit Application");

    }

    /**
     * Displays the books provided in the List along with their title, author and ISBN number.
     * @param books List of Books to be displayed
     */
    @Override
    public void displayBooks(List<IBook> books) {
        for (int i = 0; i < books.size(); ++i) {
            IBook book = books.get(i);
            String output = String.valueOf(i + 1) + ". \"" + book.getTitle() + "\" by "
                    + book.getAuthors() + ", ISBN: " + book.getISBN13();
            System.out.println(output);
            System.out.println();
        }
    }

    /**
     * Looks up and validates the ISBN along with displaying any results that match the given ISBN.
     */
    @Override
    public void isbnLookup() {
        System.out.println("You are in the Lookup ISBN Menu:");
        System.out.print("          Enter ISBN to look up: ");
        String numISBN = scnr.next();
        System.out.println(numISBN);
        if (validator.validateIISBN(numISBN)) {
            IBook finBook = backend.getByISBN(numISBN);
            String title = finBook.getTitle();
            String authors = finBook.getAuthors();
            String result = "1. " + "\"" + title + "\" by " + authors + ", ISBN: " + numISBN;
            System.out.println(result);
            System.out.println();
        }
        else {
            System.out.println("Invalid ISBN number.");
        }
        displayMainMenu();
    }

    /**
     * Searches for any book that matches the title input by the user. If the input is empty, it returns all books.
     */
    @Override
    public void titleSearch() {
        System.out.println("You are in the Search for Title Word Menu:");
        System.out.print("          Enter a word to search for in book titles (empty for all books): ");
        scnr.nextLine();
        String title = scnr.nextLine();

        List<IBook> bookList = backend.searchByTitleWord(title);
        String numBooks = String.valueOf(bookList.size());
        String totalBooks = String.valueOf(backend.getNumberOfBooks());
        System.out.println("Matches (author filter: " + backend.getAuthorFilter() + ") " +numBooks +" of " + totalBooks);

        displayBooks(bookList);
        displayMainMenu();
    }
}