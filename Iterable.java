// --== CS400 Project One File Header ==--
// Name: Karam Gursahani
// CSL Username: karam@cs.wisc.edu
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

import java.util.Iterator;
import java.util.Spliterator;

/**
 * Implementing this interface allows an object to be the target of the enhanced for statement
 * (sometimes called the "for-each loop" statement).
 *
 * @author karam
 */
public interface Iterable<ValueType> extends java.lang.Iterable {

    /**
     * Performs the given action for each element of the Iterable until all elements have been
     * processed or the action throws an exception.
     *
     * @param action
     */
    public void forEach(ValueType action);

    /**
     * Creates a Spliterator over the elements described by this Iterable.
     *
     * @return Spliterator over the elements described by this Iterable.
     */
    public Spliterator<ValueType> spliterator();


    /**
     * Returns an iterator over elements of type ValueType.
     *
     * @return Iterator<ValueType> - an iterator of ValueType.
     */
    public Iterator<ValueType> iterator();

}