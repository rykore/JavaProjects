// --== CS400 Fall 2022 File Header Information ==--
// Name: Smit Vasani
// Email: svasani@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: NONE

/**
 * @author Smit Vasani
 *
 * Takes a list of Student objects and inserts them into 2 types of RedBlack Trees based on the flag value.
 * If the flag value is 1, the RBT is optimized to insert students based on their names & if the flag value is 2, the
 * RBT is optimized to insert students based on their CID number.
 */
public class RBTMapper extends RBT implements IntRBTMapper{

    private RBT<Student> studentRBT = new RBT<>();
    public static int flag = 1;

    private Student[] temp = null;

    /**
     * Constructor for RBTMapper class
     *
     * @param flag The value based on which the students are inserted. If flag is 1, students are inserted based on
     *             their names & if the value is 2, the students are inserted based on their CID number.
     * @param arr The array containing student nodes.
     */
    public RBTMapper(int flag, Student[] arr) {
        this.flag = flag;
        this.temp = arr;
    }

    /**
     * Inserts the student objects into the tree.
     */
    public void ParseTree() {
        for (int i = 0; i < temp.length; ++i) {
            studentRBT.insert(temp[i]);
        }
    }

    /**
     * Return the final RBT
     * @return the red-black tree containing student information
     */
    public RBT<Student> getStudentRBT() {
        return this.studentRBT;
    }

}
