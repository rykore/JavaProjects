// --== CS400 Project One File Header ==--
// Name: Riya Kore
// CSL Username: kore
// Email: rykore@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

import java.util.Iterator;

public interface SortedCollectionInterface<T extends Comparable<T>>{

    /**
     * For the implementation of the dictionary, you can use this method to traverse through the source
     * file and add each word in the red black tree. Maybe call the method in the class that implements
     * this interface the WordLoader method?
     * @param data the word to be inserted, supposed to be in alphabetical order
     * @return true if the word gets correctly inserted in the tree and false if the word does not
     * @throws NullPointerException if the data given to it is null
     * @throws IllegalArgumentException if the tree already contains the word to be inserted
     */
    public boolean insertByCID(T data, int CID) throws NullPointerException, IllegalArgumentException;

    public boolean insertByName(T data, String name) throws NullPointerException, IllegalArgumentException;

    /**
     * This method can be used to search the tree for a word. It can traverse the tree and find the word.
     * @param data the word that's to be searched
     * @return true if the tree contains that word and false otherwise.
     */
    public boolean contains(T data);

    /**
     * This method will help you find the current size of the tree. This parameter will be dynamically
     * changing as the tree's size will go up everytime you add a new word. Maybe create a global variable
     * called size and increment it everytime a new word is added.
     * @return size of the tree
     */
    public int size();

    /**
     * Checks if the tree is empty or not.
     * @return true if the size of the tree is zero, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Searches for the student using their campus ID
     * @param CID you search for a student's name using the CID number
     * @return the student's SOAR ID
     */
    public int searchByCID(int CID);


    /**
     * Searches for the student using their name
     * @param name you search for a student's
     * @return
     */
    public int searchByName(String name);

    public Iterator<T> iterator();
}