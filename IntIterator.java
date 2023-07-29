// --== CS400 Project One File Header ==--
// Name: Riya Kore
// CSL Username: kore
// Email: rykore@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

public interface IntIterator {

    /**
     * This method traverses through the Nome Red Black tree and returns the String
     * representation of the Names in alphabetical order
     *
     * @return String representation of names in alphabetical order
     */
    public String toInOrderName();

    /**
     * This method traverses through the CID Red Black Tree and returns the String
     * representation of the Campus ID numbers in order
     *
     * @return String representation of the CIDs in order
     */
    public String toInOrderCID();

    /**
     * This method traverses through the Name Red Black Tree and returns the String
     * representation of the Names in Level Order, so the root node will be the first
     * element of the list, the second element is the left-most node below the root and
     * so on
     *
     * @return String representation of the names in level order
     */
    public String toLevelOrderName();

    /**
     * This method traverses through the CID Red Black Tree and returns the String
     * representation of the CID in Level Order, so the root node will be the first
     * element of the list, the second element is the left-most node below the root and
     * so on
     *
     * @return String representation of the CID numbers in level order
     */
    public String toLevelOrderCID();
}
