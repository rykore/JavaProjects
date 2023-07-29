import java.util.List;

public class BackendDeveloperTest {

    /**
     * This method tests adding of the books in the BookMapperBackend object
     * @return true if the books get added and if the books are correctly mapped with their key
     */
    public static boolean testAddBooks() {
        BookMapperBackend bookList1 = new BookMapperBackend();
        IBook Book1 = new Book1();
        IBook Book2 = new Book2();

        bookList1.addBook(Book1);
        bookList1.addBook(Book2);

        if (bookList1.bookList.containsKey("1245378424567")) {
            return true;
        }
        return false;
    }

    /**
     * Tests the size of the HashtableMap by calling the get number of books method
     * @return true if the size of the HashtableMap is equal to the expected size
     */
    public static boolean testGetNumberOfBooks() {
        BookMapperBackend bookList2 = new BookMapperBackend();
        IBook Book3 = new Book1();
        IBook Book4 = new Book2();

        bookList2.addBook(Book3);
        bookList2.addBook(Book4);
        if (bookList2.getNumberOfBooks() == 2) {
            return true;
        }
        return false;
    }

    /**
     * Tests the author filter for the books added to the BookMapperBackend object
     * @return true if the author for the added books is changed or false otherwise
     */
    public static boolean testSetAuthorFilter() {
        BookMapperBackend bookList3 = new BookMapperBackend();

        IBook Book5 = new Book1();
        IBook Book6 = new Book2();

        bookList3.addBook(Book5);
        bookList3.addBook(Book6);

        bookList3.setAuthorFilter("Isha Srivastava");

        if (!bookList3.getAuthorFilter().equals("Isha Srivastava")) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public static boolean testSearchByTitleWord() {

        BookMapperBackend bookList4 = new BookMapperBackend();

        IBook Book7 = new Book1();
        IBook Book8 = new Book2();

        bookList4.addBook(Book7);
        bookList4.addBook(Book8);

        String testTitle = "Title";

        //created a new ArrayList to store the contents of the arraylist that contains the books
        List<IBook> titleList = bookList4.searchByTitleWord(testTitle);

        if (titleList.size() == 2) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public static boolean testGetByISBN() {

        BookMapperBackend bookList5 = new BookMapperBackend();
        IBook Book9 = new Book1();
        IBook Book10 = new Book2();

        bookList5.addBook(Book9);
        bookList5.addBook(Book10);

        if (bookList5.getByISBN("1245378424567") == Book9) {
            return true;
        }
        return false;
    }

    public static boolean integrationTest1() {

        BookMapperBackend booklist6 = new BookMapperBackend();
        IBook Book11 = new Book("Title one","Author one, Author two", "1234567891234");
        IBook Book12 = new Book("Title two","Author three, Author four", "1234567895678");

        booklist6.addBook(Book11);
        booklist6.addBook(Book12);

        //testing add book and get number of books
        if (booklist6.getNumberOfBooks() == 2) {
            return true;
        }
        return false;
    }

    public static boolean integrationTest2() {

        BookMapperBackend bookList7 = new BookMapperBackend();
        Book Book13 = new Book("Title one",
                "Author one, Author two", "1234567891234");
        Book Book14 = new Book("Title two","Author three, Author four", "1234567895678");

        bookList7.addBook(Book13);
        bookList7.addBook(Book14);

        List<IBook> titleListSearch = bookList7.searchByTitleWord("Title");

        //testing searchByTitleWord method and the getByISBN method
        if (titleListSearch.size() == 2 && bookList7.getByISBN("1234567891234") == Book13) {
            return true;
        }
        return false;
    }

    public static boolean reviewTest1() {

        BookMapperBackend bookList8 = new BookMapperBackend();

        Book Book15 = new Book("Title one","Author one, Author two", "1234567891234");
        Book Book16 = new Book("Title two","Author three, Author four", "1234567895678");

        bookList8.addBook(Book15);
        bookList8.addBook(Book16);

        List<IBook> titleListSearch = bookList8.searchByTitleWord("Title");

        if (titleListSearch.size() == 2) {
            return true;
        }
        return false;

    }

    public static boolean reviewTest2() {

        BookMapperBackend bookList9 = new BookMapperBackend();
        Book Book18 = new Book("Title one","Author one, Author two", "1234567891234");
        Book Book19 = new Book("Title two","Author three, Author four", "1234567895678");

        bookList9.addBook(Book18);
        bookList9.addBook(Book19);

        if (bookList9.getByISBN("1234567891234") == Book18) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param args unused
     */
    public static void main(String[] args) {

        System.out.println("Backend Developer Test 1: " + testAddBooks());
        System.out.println("Backend Developer Test 2: " + testGetNumberOfBooks());
        System.out.println("Backend Developer Test 3: " + testSetAuthorFilter());
        System.out.println("Backend Developer Test 4: " + testSearchByTitleWord());
        System.out.println("Backend Developer Test 5:" + testGetByISBN());
        System.out.println("Data Wrangler Integration Test 1: " + integrationTest1());
        System.out.println("Data Wrangler Integration Test 2: " + integrationTest2());
        System.out.println("Smit Vasani (Frontend Developer) Test 1: " + reviewTest1());
        System.out.println("Smit Vasani (Frontend Developer) Test 2: " + reviewTest2());

    }
}
