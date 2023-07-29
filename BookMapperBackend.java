import java.util.ArrayList;
import java.util.List;

/**
 * This class helps you edit and get the books in the HastableMap of books
 */
public class BookMapperBackend extends IterableHashtableMap<String,IBook> implements IBookMapperBackend {

    //creating a HashTable of Books with unique title, author and isbn
    public IterableHashtableMap<String, IBook> bookList = new IterableHashtableMap<>();
    public String authorFilter;

    @Override
    public void addBook(IBook book) {
        bookList.put(book.getISBN13(), book);
    }

    @Override
    public int getNumberOfBooks() {
        return bookList.size();
    }

    @Override
    public void setAuthorFilter(String filterBy) {
        this.authorFilter = filterBy;
    }

    @Override
    public String getAuthorFilter() {
        if (authorFilter.isEmpty()) {
            return null;
        }
        return authorFilter;
    }

    @Override
    public void resetAuthorFilter() {
        setAuthorFilter(null);
    }

    @Override
    public List<IBook> searchByTitleWord(String word) {

        List<IBook> titleList = new ArrayList<>();

        while (bookList.iterator().hasNext()) {

            IBook book = (IBook) bookList.iterator();

            String title = book.getTitle();

            if (title.toLowerCase().contains(word.toLowerCase())
                    && book.getAuthors() == null) {
                titleList.add((IBook)(bookList).iterator());
            } else if (title.toLowerCase().contains(word.toLowerCase())
                    && book.getAuthors() != null) {
                titleList.add((IBook) (bookList).iterator());
            }

        }
        return titleList;

    }

    @Override
    public IBook getByISBN(String ISBN) {
        if (!bookList.containsKey(ISBN)) {
            return null;
        }
        return bookList.get(ISBN);
    }
}