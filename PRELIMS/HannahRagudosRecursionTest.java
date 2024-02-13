/**
 Name: Hannah Ragudos
 Date of Programming:  01/24/2023
 Activity Name: Prelim Exercise 2

 Problem and other specifications:
 Recursion Test Codes
 Create an executable class that uses the following methods. The following methods illustrate the concept of recursion.

 Input: Integer to find factorial
        Number of fibonacci

 Process: Variable declaration
          Read the entered integer
          Read the entered number
          Invoke recursive methods: factorial , fibonacci
          Utilize recursive step for each method
          Prints the factorial of the entered integer
          Prints the nth term for fibonacci
    

 Output: Factorial of the entered Integer
         Nth term of the entered number for fibonacci
 */

import java.util.Scanner;
import java.lang.*;
public class HannahRagudosRecursionTest {
    public static void main(String[] args) throws Exception {
        Scanner kbd = new Scanner(System.in);
        int number;
        int factorial =1;
        int f;
        System.out.println();
        System.out.print("Enter an integer to find the factorial: ");
        number = kbd.nextInt();
        System.out.println( "The factorial of the number is " + factorial(number));
        System.out.println();
        System.out.print("Enter number for fibonacci: ");
        f = kbd.nextInt();
        System.out.print("The nth term of the fibonacci is " + fibonacci(f - 1) + fibonacci(f - 2));
        System.out.println();
    }
    public static int factorial(int number) {
        if (number <= 1) { // base case
            return 1;
        } else { // recursive step
            return number * factorial(number - 1);
        }
    } // end method factorial

    /**
     * Recursive method for getting the nth term of a Fibonacci sequence
     */
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) { // base cases
            return n;
        } else { // recursive step
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

// SAMPLE RUN
/*
Enter an integer to find the factorial: 14
The factorial of the number is 1278945280

Enter number for fibonacci: 3
The nth term of the fibonacci is 11
 */