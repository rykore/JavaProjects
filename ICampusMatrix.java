// --== CS400 File Header Information ==--
// Name: Riya Kore
// Email: rykore@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian Heimrl
// Notes to Grader: None

import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Instances of this interface can be used to load the node data from a DOT file
 */
public interface ICampusMatrix {

    /**
     * This method loads the list of nodes from a DOT file
     * @param filename path of the DOT file
     * @return a list of node objects
     * @throws FileNotFoundException if the file is not found
     */
    List<Node> loadMatrix(String filename) throws FileNotFoundException;
}

