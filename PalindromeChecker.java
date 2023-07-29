import java.util.Scanner;

/**
 * This program checks if a word is a palindrome or not
 * @author Riya Kore
 */
public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        String reverse = "";
        for (int i = word.length() - 1 ; i >= 0 ; i--) {
            reverse = reverse + word.charAt(i);
        }
        return word.equals(reverse);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Input a word to check if it's a Palindrome or not: ");
        String word = scnr.nextLine();
        word = word.toLowerCase();

        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome :)");
        }
        else {
            System.out.println(word + " is not a palindrome :(");
        }

    }
}