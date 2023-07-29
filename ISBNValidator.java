// --== CS400 Project One File Header ==--
// Name: Karam Gursahani
// CSL Username: karam@cs.wisc.edu
// Email: kdgursahani@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to grader: None
/**
 * This class implements a method to check the validity of an ISBN-13 number
 *
 * @author karam
 *
 */
public class ISBNValidator implements IISBNValidator{

    /**
     * This method checks the validity of an ISBN-13 number
     *
     * @param numberIISBN - an ISBN number in the form of a String
     * @return boolean - true if the provided ISBN-13 string is valid, false otherwise
     */
    public boolean validateIISBN(String numberIISBN) {

        if (numberIISBN == null) {
            return false;
        }
        numberIISBN = numberIISBN.replaceAll("-", "");
        if (numberIISBN.length() != 13) {
            return false;
        }

        try {
            int sumOfTwelve = 0;
            for (int i = 0; i < numberIISBN.length() - 1; i++) {
                int digit = Integer.parseInt(numberIISBN.substring(i, i + 1));
                sumOfTwelve += (i % 2 == 0) ? digit * 1 : digit * 3;
            }
            int checksum = 10 - (sumOfTwelve % 10);

            if (checksum == 10) {
                checksum = 0;
            }
            return checksum == Integer.parseInt(numberIISBN.substring(12, 13));
        } catch (NumberFormatException nfe) {
        }

        return false;

    }

}
