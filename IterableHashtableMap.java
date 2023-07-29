// --== CS400 Project One File Header ==--
// Name: Karam Gursahani
// CSL Username: karam@cs.wisc.edu
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * This class extends HashtableMap and implements an iterator to develop an iterable hash-table.
 *
 * @author karam
 */
public class IterableHashtableMap<KeyType, ValueType> extends HashtableMap<KeyType, ValueType>
        implements IterableMapADT<KeyType, ValueType>,Iterator<ValueType> {

    /**
     * Returns an iterator over elements of type ValueType.
     *
     * @return an Iterator of ValueType
     */
    @Override
    public Iterator<ValueType> iterator() {

        ArrayList<ValueType> hashList = new ArrayList<>();
        for (int i = 0; i < hashTable.length; ++i) {
            if (hashTable[i] == null) {
                continue;
            }
            for (int j = 0; j < hashTable[i].size(); ++j) {
                if (hashTable[i].get(j) == null) {
                    continue;
                }
                hashList.add(hashTable[i].get(j).getValue());
            }
        }

        return hashList.iterator();
    }

    /**
     * This method is not required in the implementation of an iterable hash-table.
     */
    @Override
    public void forEach(ValueType action) {
    }

    /**
     * This method is not required in the implementation of an iterable hash-table.
     */
    @Override
    public Spliterator<ValueType> spliterator() {
        return null;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public ValueType next() {
        return null;
    }
}