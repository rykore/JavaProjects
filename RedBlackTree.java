// --== CS400 Project One File Header ==--
// Name: Riya Kore
// CSL Username: kore
// Email: rykore@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Red-Black Tree implementation with a Node inner class for representing
 * the nodes of the tree. Currently, this implements a Binary Search Tree that
 * we will turn into a red black tree by modifying the insert functionality.
 * In this activity, we will start with implementing rotations for the binary
 * search tree insert algorithm. You can use this class' insert method to build
 * a regular binary search tree, and its toString method to display a level-order
 * traversal of the tree.
 */
public class RedBlackTree<T extends Comparable<T>> {


    /**
     * This class represents a node holding a single value within a binary tree
     * the parent, left, and right child references are always maintained.
     */
    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild;
        public Node<T> rightChild;

        public int blackHeight;

        public Node(T data) {
            this.data = data;
            blackHeight = 0;
        }

        /**
         * @return true when this node has a parent and is the left child of
         * that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }

    }

    protected Node<T> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree. After
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException when the provided data argument is null
     * @throws IllegalArgumentException when the newNode and subtree contain
     *      equal data references
     */
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {

        // null references cannot be stored within this tree
        if (data == null) {
            throw new NullPointerException(
                    "This RedBlackTree cannot store null references.");
        }

        Node<T> newNode = new Node<>(data);

        if(root == null) {
            root = newNode; // add first node to an empty tree
            size++;
            root.blackHeight = 1;
            return true;
        }
        else {
            boolean returnValue = insertHelper(newNode,root); // recursively insert into subtree

            if (returnValue) {
                size++;
            }
            else {
                throw new IllegalArgumentException(
                        "This RedBlackTree already contains that value.");
            }

            root.blackHeight = 1;
            return returnValue;
        }
    }

    /**
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the
     *      newNode should be inserted as a descendant beneath
     * @return true is the value was inserted in subtree, false if not
     */
    private boolean insertHelper(Node<T> newNode, Node<T> subtree) {

        //call enforceRBTreePropertiesAfterInsert in this method to rearrange the tree
        //TODO: call the below method in this method

        int compare = newNode.data.compareTo(subtree.data);
        // do not allow duplicate values to be stored within this tree
        if(compare == 0)
            return false;

            // store newNode within left subtree of subtree
        else if(compare < 0) {

            if(subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                return true;

                // otherwise, continue recursive search for location to insert
            }
            else {
                return insertHelper(newNode, subtree.leftChild);
            }
        }

        // store newNode within the right subtree of subtree
        else {
            if(subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(newNode);
                return true;
                // otherwise, continue recursive search for location to insert
            }
            else {
                return insertHelper(newNode, subtree.rightChild);
            }
        }
    }

    /**
     * This method helps enforce the Red black tree properties after any of the operations
     *
     * @param newNode the new node that's being inserted
     */
    protected void enforceRBTreePropertiesAfterInsert(Node<T> newNode) {

        //checks if the new node inserted is null or not
        if (newNode == null) {
            return;
        }

        //checks if the parent is not null and parent is red
        if (newNode.parent != null && newNode.parent.blackHeight == 0) {

            //uncle is red situation 1
            //if parent is the left child
            if (newNode.parent.isLeftChild()) {

                //uncle is black or uncle is null
                if (newNode.parent.parent.rightChild == null ||
                        newNode.parent.parent.rightChild.blackHeight == 1) {

                    //if the new node is right child
                    if (newNode.parent.rightChild != null && newNode.parent.rightChild == newNode) {

                        Node tempParent = newNode.parent;

                        rotate(newNode, newNode.parent);
                        rotate(newNode, newNode.parent);

                        newNode = newNode.leftChild;
                        newNode.parent.blackHeight = 1;
                        //after rotation, parent should become the new newNode

                        if (newNode.parent.rightChild != null) {
                            newNode.parent.rightChild.blackHeight = 0;
                        }
                    }

                    //if the new node is left child
                    else if (newNode.isLeftChild()) {
                        rotate(newNode.parent,newNode.parent.parent);
                        newNode.parent.blackHeight = 1;  //recoloured parent to black

                        //if the new rightchild exists, color it to red
                        if (newNode.parent.rightChild != null) {
                            newNode.parent.rightChild.blackHeight = 0;  //recoloured the new rightchild of parent to red
                        }
                    }
                }

                //uncle is red
                else {
                    newNode.parent.blackHeight = 1;   //parent recoloured to black
                    newNode.parent.parent.rightChild.blackHeight = 1;  //uncle recoloured to black
                    newNode.parent.parent.blackHeight = 0;
                    enforceRBTreePropertiesAfterInsert(newNode.parent.parent);
                }
            }

            //uncle is red situation 2
            //if parent is the right child
            else if (newNode.parent.parent != null && !newNode.parent.isLeftChild()) {

                //uncle is black or uncle is null
                if (newNode.parent.parent.leftChild == null ||
                        newNode.parent.parent.leftChild.blackHeight == 1) {

                    //if the new node is left child
                    if (newNode.isLeftChild()) {
                        Node tempParent = newNode.parent;

                        rotate(newNode, newNode.parent);
                        rotate(newNode, newNode.parent);

                        newNode = newNode.rightChild;
                        newNode.parent.blackHeight = 1;

                        if (newNode.parent.leftChild != null) {
                            newNode.parent.leftChild.blackHeight = 0;
                        }
                    }

                    //if the new node is right child
                    else if (newNode.parent.rightChild != null && newNode.parent.rightChild == newNode) {

                        rotate(newNode.parent,newNode.parent.parent);
                        newNode.parent.blackHeight = 1;  //recoloured parent to black

                        if (newNode.parent.leftChild != null) {
                            //recoloured the new leftchild of parent to red
                            newNode.parent.leftChild.blackHeight = 0;
                        }
                    }
                }

                //uncle is red
                else {
                    newNode.parent.blackHeight = 1;  //parent recoloured to black
                    newNode.parent.parent.leftChild.blackHeight = 1; //uncle recoloured to black
                    newNode.parent.parent.blackHeight = 0;
                    enforceRBTreePropertiesAfterInsert(newNode.parent.parent);
                }
            }
            else {
                return;
            }
        }
    }

    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * rightChild of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {

        //if the child and parent references are not related
        if (parent.leftChild != child && parent.rightChild != child) {
            throw new IllegalArgumentException("Child node and Parent node are not related! Cannot perform rotate");
        }

        //if the child is the left child
        else if (parent.leftChild == child) {
            parent.leftChild = child.rightChild;

            //if child is not the leaf node
            if (child.rightChild != null) {
                child.rightChild.parent = parent;
            }
            child.parent = parent.parent;

            //if parent is the root
            if (parent.parent == null) {
                root = child;
            }

            //if parent is the left child
            else if (parent.parent.leftChild == parent) {
                parent.parent.leftChild = child;
            }

            //if parent is the right child
            else {
                parent.parent.rightChild = child;
            }

            //reassigning references
            child.rightChild = parent;
            parent.parent = child;
        }

        //if child is the right child
        else {
            parent.rightChild = child.leftChild;

            //if child is not the leaf node
            if (child.leftChild != null) {
                child.leftChild.parent = parent;
            }
            child.parent = parent.parent;

            //if parent is the root
            if (parent.parent == null) {
                root = child;
            }

            //if parent is the left child
            else if (parent.parent.leftChild == parent) {
                parent.parent.leftChild = child;
            }

            //parent is the right child
            else {
                parent.parent.rightChild = child;
            }

            //reassigning references
            child.leftChild = parent;
            parent.parent = child;
        }
    }

    /**
     * Get the size of the tree (its number of nodes).
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     * @return true of this.size() return 0, false if this.size() > 0
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * This method is used to search up a student based on the input, which could
     * be either the Campus ID or the Name of that student.
     * @param data the data to be searched
     * @return the student based on the data
     */
    public T search(T data) {
        if (data == null) {
            return null;
        }
        return this.searchHelper(data, root);
    }

    /**
     * This is the helper method for the above search method that compares the data
     * to the current node and returns the student object when the data matches
     * @param data the data of the student object to be searched for
     * @param node the current node that is compared with
     * @return the data of the node
     */
    public T searchHelper(T data, Node<T> node) {

        if (node == null) {
            return null;
        }
        else {
            int compare = data.compareTo(node.data);
            if (compare < 0) {
                return searchHelper(data,node.leftChild);
            }
            else if (compare > 0) {
                return searchHelper(data,node.rightChild);
            }
            else {
                return node.data;
            }
        }
    }

    /**
     * Checks whether the tree contains the value *data*.
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */
    public boolean contains(T data) {
        // null references will not be stored within this tree
        if(data == null) {
            throw new NullPointerException(
                    "This RedBlackTree cannot store null references.");
        }
        return this.containsHelper(data, root);
    }

    /**
     * Recursive helper method that recurses through the tree and looks
     * for the value *data*.
     * @param data the data value to look for
     * @param subtree the subtree to search through
     * @return true of the value is in the subtree, false if not
     */
    private boolean containsHelper(T data, Node<T> subtree) {
        if (subtree == null) {
            // we are at a null child, value is not in tree
            return false;
        }
        else {
            int compare = data.compareTo(subtree.data);
            if (compare < 0) {
                // go left in the tree
                return containsHelper(data, subtree.leftChild);
            }
            else if (compare > 0) {
                // go right in the tree
                return containsHelper(data, subtree.rightChild);
            }
            else {
                // we found it :)
                return true;
            }
        }
    }

    /**
     * This method performs an inorder traversal of the tree. The string
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * Note that this RedBlackTree class implementation of toString generates an
     * inorder traversal. The toString of the Node class above
     * produces a level order traversal of the nodes / values of the tree.
     * @return string containing the ordered values of this tree (in-order traversal)
     */
    public String toInOrderString() {

        // generate a string of all values of the tree in (ordered) in-order
        // traversal sequence
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        sb.append(toInOrderStringHelper("", this.root));
        if (this.root != null) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }

    private String toInOrderStringHelper(String str, Node<T> node){
        if (node == null) {
            return str;
        }
        str = toInOrderStringHelper(str, node.leftChild);
        str += (node.data.toString() + ", ");
        str = toInOrderStringHelper(str, node.rightChild);
        return str;
    }

    /**
     * This method performs a level order traversal of the tree rooted
     * at the current node. The string representations of each data value
     * within this tree are assembled into a comma separated string within
     * brackets (similar to many implementations of java.util.Collection).
     * Note that the Node's implementation of toString generates a level
     * order traversal. The toString of the RedBlackTree class below
     * produces an inorder traversal of the nodes / values of the tree.
     * This method will be helpful as a helper for the debugging and testing
     * of your rotation implementation.
     * @return string containing the values of this tree in level order
     */
    public String toLevelOrderString() {
        String output = "[ ";
        if (this.root != null) {
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this.root);
            while(!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if(next.leftChild != null) q.add(next.leftChild);
                if(next.rightChild != null) q.add(next.rightChild);
                output += next.data.toString();
                if(!q.isEmpty()) output += ", ";
            }
        }
        return output + " ]";
    }

    public String toString() {
        return "level order: " + this.toLevelOrderString() +
                "\nin order: " + this.toInOrderString();
    }
}



