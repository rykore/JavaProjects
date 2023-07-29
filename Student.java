// --== CS400 Fall 2022 File Header Information ==--
// Name: Smit Vasani
// Email: svasani@wisc.edu
// Team: EB
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: This class was implemented by the Backend Developer (transferred from Algorithm Engineer).

/**
 * A new object having name, SID & CID fields
 */
public class Student implements Comparable<Student>,IStudent {
    private int SOARID;
    private String name;
    private int CID;

    /**
     * Constructor for the Student object
     * @param name name of the student
     * @param SOARID SOAR ID of the student
     * @param CID Campus ID of the student
     */
    public Student (String name, int CID, int SOARID) {
        this.name = name;
        this.SOARID = SOARID;
        this.CID = CID;
    }

    @Override
    /**
     * Return the SOAR ID of the student.
     * @return The SOAR ID of the student
     */
    public int getSOARID() {
        return this.SOARID;
    }
    @Override
    /**
     * Return the Campus ID of the student
     * @return The Campus ID of the student
     */
    public int getCID() {
        return this.CID;
    }
    @Override
    /**
     * Return the name of the student
     * @return Name of the student
     */
    public String getName() {
        return this.name;
    }


    @Override
    /**
     * Method to compare the students for inserting them into RBT in the right manner.
     */
    public int compareTo(Student o) {
        if (RBTMapper.flag == 1) {
            if (this.name.compareTo(o.name) > 0) {
                return 1;
            }
            else if (this.name.compareTo(o.name) < 0) {
                return -1;
            }
            else {
                return 0;
            }
        }
        else {
            if (this.CID == o.CID) {
                return 0;
            }
            else if (this.CID > o.CID) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }


}
