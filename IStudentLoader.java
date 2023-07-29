import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Instances of this interface can be used to load student data from an XML file.
 *
 * @author Tushar Choudhary
 */
public interface IStudentLoader {

    /**
     * This method loads the list of books from an XML file.
     * @param filepathToXML path to the XML file relative to the executable
     * @return a list of student objects
     * @throws FileNotFoundException
     * @throws IOException
     */
    List<IStudent> loadStudents(String filepathToXML) throws FileNotFoundException, IOException;

}