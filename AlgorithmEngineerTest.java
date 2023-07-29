// --== CS400 Project One File Header ==--
// Name: Karam Gursahani
// CSL Username: karam@cs.wisc.edu
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None


/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * IterableHashtableMap as well as IISBNValidator
 *
 * @author karam
 */
public class AlgorithmEngineerTest {

    /**
     * This method checks whether the validateIISBN() method returns false for a number of invalid
     * ISBN-13 numbers
     *
     * @return boolean - if the validateIISBN() function operates as required for invalid ISBN13
     *         numbers then true is returned, otherwise false is returned.
     */
    public static boolean test1() {
        int errors = 0;
        String numberIISBNOne = ""; // null
        String numberIISBNTwo = "978-0306-406-1566"; // extra characters

        ISBNValidator newValidator = new ISBNValidator();

        if (newValidator.validateIISBN(numberIISBNOne)) {
            errors++;
        }

        if (newValidator.validateIISBN(numberIISBNTwo)) {
            errors++;
        }


        if (errors != 0) {
            System.out.println("problem in 1");
            return false;
        }

        return true;

    }

    /**
     * This method checks whether the validateIISBN() method returns true for a valid ISBN-13 numbers
     *
     * @return boolean - if the validateIISBN() function operates as required for valid ISBN13 numbers
     *         then true is returned, otherwise false is returned.
     */
    public static boolean test2() {
        int errors = 0;
        String numberIISBNOne = "978-0306-406-157";

        ISBNValidator newValidatorTwo = new ISBNValidator();

        if (!newValidatorTwo.validateIISBN(numberIISBNOne)) {
            errors++;
        }

        if (errors != 0) {
            System.out.println("problem in 2");
            return false;
        }

        return true;

    }

    /**
     * This method checks whether the iterator() method functions appropriately for an non-empty
     * hash-table with string values.
     *
     * @return boolean - if the hasNext() function operates as required for hash-tables with string
     *         then true is returned, otherwise false is returned.
     */
    public static boolean test3() {


        IterableHashtableMap<String, String> mapOne = new IterableHashtableMap<String, String>();
        mapOne.put("a", "1");
        mapOne.put("b", "2");
        mapOne.put("c", "3");
        String checkString = "";
        for (Object s : mapOne) {
            checkString += s.toString();
        }
        if (!(checkString.contains("1")) || !(checkString.contains("2"))
                || !(checkString.contains("3"))) {
            return false;
        }
        return true;

    }

    /**
     * This method checks whether the iterator() method functions appropriately for an non-empty
     * hash-table with integer values.
     *
     * @return boolean - if the hasNext() function operates as required for hash-tables with integer
     *         then true is returned, otherwise false is returned.
     */
    public static boolean test4() {

        IterableHashtableMap<Integer, Integer> mapOne = new IterableHashtableMap<Integer, Integer>();
        mapOne.put(9081, 10);
        mapOne.put(4432, 51);
        mapOne.put(2289, 12);
        Integer checkSum = 0;
        for (Object i : mapOne) {
            checkSum += (Integer) i;
        }
        if (checkSum != 73) {
            return false;
        }
        return true;

    }

    /**
     * This method checks whether the validateIISBN() method returns false for an invalid ISBN-13
     * number which is not null and is of correct length.
     *
     * @return boolean - if the validateIISBN() function operates as required for invalid ISBN13
     *         numbers then true is returned, otherwise false is returned.
     */
    public static boolean test5() {

        String numberIISBNOne = "9780karam3450";
        String numberIISBNTwo = "978-0306-406-156"; // invalid ISBN-13 numbers

        ISBNValidator newValidatorThree = new ISBNValidator();

        if (newValidatorThree.validateIISBN(numberIISBNOne)
                || newValidatorThree.validateIISBN(numberIISBNTwo)) {
            return false;
        }

        return true;


    }

    /**
     * Calls the test methods
     *
     * @param args input arguments if any
     */
    public static void main(String[] args) {
        if (test1() && test2() && test3() && test4() && test5()) {
            System.out.println("All tests passed in IterableHashtableMap class!");
        } else {
            System.out.println("Re-check tester methods!");
        }
    }

}