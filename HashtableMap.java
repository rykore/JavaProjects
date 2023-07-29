// --== CS400 Project One File Header ==--
// Name: Karam Gursahani
// CSL Username: karam@cs.wisc.edu
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class implements several methods to ultimately build a Hashtable.
 *
 * @author karam
 *
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

    protected LinkedList<kvpair<KeyType, ValueType>>[] hashTable;
    protected int capacity;
    protected int size;
//  Iterator<ValueType> current;
//  protected int positionArray;
//  protected int positionLinkedList;


    /**
     * Hashtable constructor method that initializes an array (of length 15) of linked lists.
     * Additionally, it constructs a linked list at each index of the array.
     *
     */
    public HashtableMap() {
        this.capacity = 15;
        hashTable = new LinkedList[this.capacity];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList();
        }
        size = 0;
    }

    /**
     * Hashtable constructor method that initializes an array of linked lists by using the argument
     * capacity. Additionally, it constructs a linked list at each index of the array.
     *
     * @param capacity - the capacity of the array of linked lists
     */
    public HashtableMap(int capacity) {
        this.capacity = capacity;
        hashTable = new LinkedList[this.capacity];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList();
        }
        size = 0;
    }

    /**
     * Helper method that returns the index of the hash table that is equal to the absolute value of
     * the hashCode() modulus the hash table's current capacity
     *
     * @param key  - key that needs to be hashed
     * @return int - index of the hashTable that the key hashes to
     */
    private int hashFunction(KeyType key) {
        return Math.abs(key.hashCode() % capacity);
    }

    /**
     * This method returns if a key was present in the hash table. It also checks for the cases that
     * if the size of the linked-list at the hash index is 0 or if the key is null, false should be
     * returned.
     *
     * @param key - key that needs to checked
     * @return int - index of the hashTable that the key hashes to
     */
    @Override
    public boolean containsKey(KeyType key) {

        int hashIndex = hashFunction(key);
        if (hashTable[hashIndex] == null || hashTable[hashIndex].size() == 0) {
            return false;
        }
        for (int i = 0; i < hashTable[hashIndex].size(); i++) {
            if (hashTable[hashIndex].get(i).getKey().equals(key)) {
                return true;
            }
        }
        return false;

    }

    /**
     * The following helper method doubles the size of the hash table when the load capacity is
     * greater than 70% by creating a new array of linked lists that has twice the capacity as the old
     * one. Consequently, it traverses through each node in the linked list in each of the indices of
     * the array and rehashes the key to find its position in the new array.
     *
     * @return a new hash table that is double in capacity with all the values rehashed
     */
    private LinkedList<kvpair<KeyType, ValueType>>[] growHashTable() {
        capacity = capacity * 2;
        LinkedList<kvpair<KeyType, ValueType>>[] newTable = new LinkedList[capacity];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new LinkedList();
        }
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                for (int j = 0; j < hashTable[i].size(); j++) {
                    kvpair<KeyType, ValueType> currentPair = hashTable[i].get(j);
                    int hashIndex = hashFunction(currentPair.getKey());
                    newTable[hashIndex].add(currentPair);
                }
            }
        }
        return newTable;
    }

    /**
     * Helper method that attemps to return whether a key,value pair was succesfully hashed into the
     * hash table. It returns false if the containsKey method returns false. If a key,value pair can
     * be succesfully hashed into the hash table, this method returns true. To keep load factor of the
     * hash table lower than 0.7, the hash table grows in capacity, by calling the growHashTable()
     * method.
     *
     * @param key   - key that needs to be hashed
     * @param value - used to find the capacity of the hash table that the k,v pair is being inserted
     *              into
     * @return boolean - if a key,value pair was succesfully hashed into the hash table
     */
    @Override
    public boolean put(KeyType key, ValueType value) {
        if (containsKey(key) || key == null) {
            return false;

        }

        int hashIndex = hashFunction(key);
        kvpair<KeyType, ValueType> tempPair = new kvpair<KeyType, ValueType>(key, value);
        hashTable[hashIndex].add(tempPair);
        ++size;

        if (Double.valueOf(size) / capacity >= 0.7) {
            hashTable = growHashTable();
        }
        return true;
    }

    /**
     * Returns the value stored within a key, value pair within the hash table.
     *
     * @throws NoSuchElementException - if containsKey(key) returns false
     * @param key - reference to key that needs to be searched for to help find the value paired with
     *            it
     * @return ValueType - Value of a given key within the hash table
     */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        if (!containsKey(key)) {
            throw new NoSuchElementException();
        }
        int hashIndex = hashFunction(key);
        for (int i = 0; i < hashTable[hashIndex].size(); i++) {
            if (hashTable[hashIndex].get(i).getKey().equals(key)) {
                return hashTable[hashIndex].get(i).getValue();
            }
        }
        return null;
    }

    /**
     * Returns a reference to the Value located within a key,value pair that is being removed. If the
     * key being removed returns false when the containsKey() method is called, the method will then
     * return null.
     *
     * @param key - reference to key which needs to be removed from the hashTable
     * @return ValueType - the value of key that is removed from the hashTable. null - if hashTable
     *         does not contain the key that needs to be removed.
     */
    @Override
    public ValueType remove(KeyType key) {
        if (!containsKey(key)) {
            return null;
        } else {
            int hashIndex = hashFunction(key);
            for (int i = 0; i < hashTable[hashIndex].size(); i++) {
                if (hashTable[hashIndex].get(i).getKey().equals(key)) {
                    ValueType value = (ValueType) hashTable[hashIndex].get(i).getValue();
                    hashTable[hashIndex].remove(i);
                    --size;
                    return value;
                }
            }
            return null;
        }
    }


    /**
     * Removes all the key-value pairs from hashTable and sets the size to 0.
     */
    @Override
    public void clear() {
        hashTable = new LinkedList[capacity];
        size = 0;
    }


    /**
     * Returns the number of key-value pairs that are stored in a given linked list of the hash table
     * @return int - number of key-value pairs
     */
    @Override
    public int size() {
        return size;
    }

}