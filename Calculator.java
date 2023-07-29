import java.util.Scanner;

/**
 * This program is a simple calculator that performs 4 operations
 * @author Riya Kore
 */
public class Calculator {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.print("You have to input two numbers and the program will ");
        System.out.println("output the answer based on the operation you choose.");
        double num1;
        double num2;
        char operationIs;
        double answerIs = 0.0;

        System.out.println("Enter first number: ");
        num1 = scnr.nextDouble();

        System.out.println("Enter second number: ");
        num2 = scnr.nextDouble();

        System.out.println("Enter operation: ");
        System.out.println("Choose from + , - , * , /");
        operationIs = scnr.next().charAt(0);

        if (operationIs == '+'){
            answerIs = num1 + num2;
        }
        else if (operationIs == '-') {
            answerIs = num1 - num2;
        }
        else if (operationIs == '*') {
            answerIs = num1 * num2;
        }
        else if (operationIs == '/') {
            answerIs = num1 / num2;
        }
        
        System.out.print("Your answer is: " + answerIs);
    }
}
