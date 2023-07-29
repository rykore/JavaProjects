import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Load book data from a CSV file.
 *
 * @author Sam Katerov
 */
public class BookLoader implements IBookLoader {

    /**
     * This method loads the list of books from a CSV file.
     *
     * @param filepathToCSV path to the CSV file relative to the executable
     * @return a list of book objects
     * @throws FileNotFoundException
     */
    @Override
    public List<IBook> loadBooks(String filepathToCSV) throws FileNotFoundException {
        List<IBook> books = new ArrayList<>();
        Path filePath = Paths.get(filepathToCSV);

        // Use BufferedReader to read the CSV file
        try (BufferedReader bReader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {

            // Read the first line from CSV
            String line = bReader.readLine();

            // Check all lines
            while (line != null) {

                // loads the attributes from each line by column
                String[] attributes = line.split(",");
                String title = attributes[1];
                String authors = attributes[2];
                String isbn13 = attributes[5];

                // constuct new book
                Book book = new Book(title, authors, isbn13);

                // adding book into ArrayList
                books.add(book);

                // read next line to check, if end of line
                line = bReader.readLine();
            }
        } catch (IOException ioe) {
            throw new FileNotFoundException("An error occurred while parsing the file");
        }
        // return book array
        return books;
    }
}