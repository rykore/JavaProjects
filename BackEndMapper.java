import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackEndMapper implements IBookMapperBackend{

    HashMap<String,IBook> bookHashMap = new HashMap<>();
    protected String authorFilter;

    List<IBook> bookTitle = new ArrayList<>();
    List<IBook> bookAuthor = new ArrayList<>();

    @Override
    public void addBook(IBook book) {
        bookHashMap.put(book.getISBN13(), (IBook) bookTitle);
    }

    @Override
    public int getNumberOfBooks() {
        return bookHashMap.size();
    }

    @Override
    public void setAuthorFilter(String filterBy) {
        authorFilter = filterBy;
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

        for (int i = 0; i < bookHashMap.size(); i++) {
            if (bookHashMap.containsValue(word)) {
                titleList.add(bookHashMap.get(i));
            }
        }
        return titleList;
    }

    @Override
    public IBook getByISBN(String ISBN) {
        for (int i = 0; i < bookHashMap.size(); i++) {
            if (bookHashMap.containsKey(ISBN)) {
                return bookHashMap.get(ISBN);
            }
        }
        return null;
    }
}
