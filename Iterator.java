// --== CS400 Project One File Header ==--
// Name: Karam Gursahani
// CSL Username: karam@cs.wisc.edu
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

/**
 * This interface lays down the required methods for an Iterator type
 *
 * @author karam
 */
public interface Iterator<ValueType> extends java.util.Iterator<ValueType> {
    /**
     * This method checks whether the iteration has more elements.
     *
     * @return boolean - true if the iteration has more elements remaining.
     */
    public boolean hasNext();

    /**
     * This method returns the next value in the iteration of the type ValueType.
     *
     * @return ValueType - the next value in the iteration.
     */
    public ValueType next();

}