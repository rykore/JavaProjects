// --== CS400 Project One File Header ==--
// Name: Riya Kore
// CSL Username: kore
// Email: rykore@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None

/**
 *
 * This interface defines the getter methods for each student's data as the
 * name, Campus ID number and the SOAR reservation number and is implemented
 * by the classes that represent a student and their associated data.
 *
 * @author Riya Kore
 */
public interface IStudent {

    /**
     * Returns the name of the Student
     * @return name of the student
     */
    public String getName();

    /**
     * Returns the Campus ID number of the student
     * @return Campus ID number of the student
     */
    public int getCID();

    /**
     * Returns the SOAR ID number of the student
     * @return the SOAR ID number of the student
     */
    public int getSOARID();

}
