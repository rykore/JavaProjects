// --== CS400 Project One File Header ==--
// Name: Karam Gursahani
// CSL Username: karam@cs.wisc.edu
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

/**
 * This class implements basic the constructor and getter methods to build a key,value pair.
 *
 * @author karam
 */
public class kvpair<KeyType, ValueType> {

    private KeyType key;
    private ValueType value;

    /**
     * Constructor that initializes the key and value variables with the arguments that were passed
     * in.
     *
     * @param key   - key that needs to be hashed
     * @param value - value that needs to be stored in the hash table
     */
    public kvpair(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Accessor method that is used to return the key in a key-value pair.
     *
     * @return key - KeyType
     */
    public KeyType getKey() {
        return this.key;
    }

    /**
     * Accessor method that is used to return the value in a key-value pair.
     *
     * @return value - ValueTYpe
     */
    public ValueType getValue() {
        return this.value;
    }
}