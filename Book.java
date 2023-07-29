/**
 * This interfaces with IBook.java has getter methods for each book's data attributes
 *
 * @author Sam Katerov
 */
public class Book implements IBook {

    private String title;
    private String authors;
    private String isbn13;

    public Book(String title, String authors, String isbn13) {
        this.title = title;
        this.authors = authors;
        this.isbn13 = isbn13;
    }

    /**
     * Returns the title of the book.
     *
     * @return title of the book
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Returns a string that contains the authors of the book
     * as a single string with different authors separated by /.
     *
     * @return author names as single string
     */
    @Override
    public String getAuthors() {
        return authors;
    }

    /**
     * Returns the 13 digit ISBN (ISBN13) that uniquely identifies this book.
     *
     * @return ISBN number of book
     */
    @Override
    public String getISBN13() {
        return isbn13;
    }

}