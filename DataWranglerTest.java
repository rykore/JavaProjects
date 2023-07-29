import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Checks if BookLoader.java and Book.java work
 *
 * @author Sam Katerov
 */
public class DataWranglerTest {

    static BookLoader bookArray = new BookLoader(); // define our array for tests
    static List<IBook> books = new ArrayList<>();

    /**
     * Tests the getter methods
     *
     * @return True if passed, false otherwise
     */
    public static boolean test1() {
        Book book = new Book("Harry Potter and the Half-Blood Prince (Harry Potter  #6)", "J.K. Rowling/Mary GrandPré",
                "9780439785969"); // define a test book

        if (!book.getTitle().equals("Harry Potter and the Half-Blood Prince (Harry Potter  #6)")) {
            return false;
        }
        if (!book.getAuthors().equals("J.K. Rowling/Mary GrandPré")) {
            return false;
        }
        if (!book.getISBN13().equals("9780439785969")) {
            return false;
        }
        System.out.println("Test 1: Passed");
        return true;
    }

    /**
     * Tests the FileNotFound exception
     *
     * @return True if passed, false otherwise
     */
    public static boolean test2() {
        int pass = 0;
        try {
            bookArray.loadBooks("notBooks.csv"); // not a real file
        } catch (FileNotFoundException e) { // throws exception is good
            pass++;
        }

        try {
            bookArray.loadBooks("books.csv"); // real file
        } catch (FileNotFoundException e) { // should not throw exception
            return false;
        }

        if (pass == 1) {
            return true;
        }
        System.out.println("Test 2: Passed");
        return false;
    }

    /**
     * Test book loading array
     *
     * @return True if passed, false otherwise
     */
    public static boolean test3() {
        try {
            books = bookArray.loadBooks("books.csv");
        } catch (FileNotFoundException e) {
            return false;
        }

        if (!books.get(1).getTitle().equals("Harry Potter and the Half-Blood Prince (Harry Potter  #6)")) {
            return false;
        }
        if (!books.get(1).getAuthors().equals("J.K. Rowling/Mary GrandPré")) {
            return false;
        }
        if (!books.get(1).getISBN13().equals("9780439785969")) {
            return false;
        }
        System.out.println("Test 3: Passed");
        return true;
    }

    /**
     * Test book loading array with escaped quotes
     *
     * @return True if passed, false otherwise
     */
    public static boolean test4() {
        try {
            books = bookArray.loadBooks("books.csv");
        } catch (FileNotFoundException e) {
            return false;
        }
        if (!books.get(6).getTitle()
                .equals("Unauthorized Harry Potter Book Seven News: \\\"Half-Blood Prince\\\" Analysis and Speculation")) {
            return false;
        }
        if (!books.get(6).getAuthors().equals("W. Frederick Zimmerman")) {
            return false;
        }
        if (!books.get(6).getISBN13().equals("9780976540601")) {
            return false;
        }
        System.out.println("Test 4: Passed");
        return true;
    }

    /**
     * Test book loading array with single quote
     *
     * @return True if passed, false otherwise
     */
    public static boolean test5() {
        try {
            books = bookArray.loadBooks("books.csv");
        } catch (FileNotFoundException e) {
            return false;
        }
        if (!books.get(802).getTitle()
                .equals("The Wealthy Barber: Everyone's Common-Sense Guide to Becoming Financially Independent")) {
            return false;
        }
        if (!books.get(802).getAuthors().equals("David H. Chilton")) {
            return false;
        }
        if (!books.get(802).getISBN13().equals("9780761501664")) {
            return false;
        }
        System.out.println("Test 5: Passed");
        return true;
    }

    // Integration tests
    public static boolean IntTest1() {
        try {
            books = bookArray.loadBooks("books.csv");
        } catch (FileNotFoundException e) {
            return false;
        }
        if (!books.get(2227).getTitle().equals("Speaker for the Dead (Ender's Saga  #2)")) {
            return false;
        }
        if (!books.get(2227).getAuthors().equals("Orson Scott Card")) {
            return false;
        }
        if (!books.get(2227).getISBN13().equals("9780812550757")) {
            return false;
        }
        System.out.println("INT Test 1: Passed");
        return true;
    }

    public static boolean IntTest2() {
        try {
            books = bookArray.loadBooks("books.csv");
        } catch (FileNotFoundException e) {
            return false;
        }
        if (!books.get(38).getTitle().equals("The Changeling")) {
            return false;
        }
        if (!books.get(38).getAuthors().equals("Kate Horsley")) {
            return false;
        }
        if (!books.get(38).getISBN13().equals("9781590301944")) {
            return false;
        }
        System.out.println("INT Test 2: Passed");
        return true;
    }

    // Partner tests
    public static boolean DWTest1() {
        try {
            books = bookArray.loadBooks("books.csv");
        } catch (FileNotFoundException e) {
            return false;
        }
        if (!books.get(43).getTitle().equals("Traders  Guns & Money: Knowns and Unknowns in the Dazzling World of Derivatives")) {
            return false;
        }
        if (!books.get(43).getAuthors().equals("Satyajit Das")) {
            return false;
        }
        if (!books.get(43).getISBN13().equals("9780273704744")) {
            return false;
        }
        System.out.println("DW Test 1: Passed");
        return true;
    }

    public static boolean DWTest2() {
        try {
            books = bookArray.loadBooks("books.csv");
        } catch (FileNotFoundException e) {
            return false;
        }
        if (!books.get(328).getTitle().equals("1776")) {
            return false;
        }
        if (!books.get(328).getAuthors().equals("Peter  Stone/Sherman Edwards")) {
            return false;
        }
        if (!books.get(328).getISBN13().equals("9780140481396")) {
            return false;
        }
        System.out.println("DW Test 2: Passed");
        return true;
    }

    public static void main(String[] args) {
        runAll();
    }

    /**
     * Runs all tests
     *
     * @return True if passed, false otherwise
     */
    public static boolean runAll() {
        System.out.println("Data Wrangler Test 1: " + test1());
        System.out.println("Data Wrangler Test 2: " + test2());
        System.out.println("Data Wrangler Test 3: " + test3());
        System.out.println("Data Wrangler Test 4: " + test4());
        System.out.println("Data Wrangler Test 5:" + test5());
        System.out.println("Integration Test 1: " + IntTest1());
        System.out.println("Integration Test 2: " + IntTest2());
        System.out.println("Riya Kore (Backend Developer) Test 1: " + DWTest1());
        System.out.println("Riya Kore (Backend Developer) Test 2: " + DWTest2());
        return true;
    }
}