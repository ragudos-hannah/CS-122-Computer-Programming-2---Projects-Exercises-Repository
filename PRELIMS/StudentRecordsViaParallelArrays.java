/**
 * Name of Student/Programmer: Hannah Ragudos
 * CLASS CODE & Schedule: 9:00 - 10:30 TF D522
 * Date: 01/31/2023
 * Student Records Keeping Using Parallel Arrays
 * <p>
 * An ID number, a name, a course, a year level and others are
 * attributed to a student. Hence, eight arrays are
 * used: An array that stores ID numbers, an array that
 * stores names, an array that stores courses, an array
 * that stores year levels, etc. The eight arrays are treated
 * as parallel arrays such that the first elements of the
 * eight arrays are actual attributes (ID number, name, course,
 * year level, etc. ) of one student, the second elements are
 * actual attributes of another student, and so on.
 * <p>
 * <p>
 * REQUIRED:
 * Complete and show a sample run (sample output) of the following
 program.

 *The sample run should be shown below as part of this multiline comment
 **/
package prelims;
import  java.util.*;
public class StudentRecordsViaParallelArrays {
    static Scanner keyboard = new Scanner(System.in);public static void
    main(String[] args) {
        String[] id; // Array that will store ID numbers
        String[] names; // Array that will store names
        String[] course;// Array that will store courses
        int[] yearLevel; // array that will store year levels
        int count; // variable that will store the number of students
        byte[] pGrade; // to store prelim grade
        byte[] mGrade; // to store midterm grade
        byte[] tFGrade; // to store tentative Final Grade
        byte[] fGrade; // to store final grade

// Read the number of students to be recorded from the keyboard
        System.out.print("How many student records will be created?");
        count = Integer.parseInt(keyboard.nextLine());

// Instantiate the arrays such that each will have a length=size
        id = new String[count];
        names = new String[count];
        course = new String[count];
        yearLevel = new int[count];
        pGrade = new byte[count];
        mGrade = new byte[count];
        tFGrade = new byte[count];
        fGrade = new byte[count];

//Invoke the method that will fill the arrays with elements
        populateArrays(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);

// Show the students following the order by which they were entered
        System.out.println("\nOriginal Order Data");
        showData(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);

// Invoke the method that will sort the arrays in parallel
        sortDataBasedOnNames(id, names, course, yearLevel, pGrade, mGrade,
                tFGrade, fGrade, count);// Invoke the method for displaying the array elements

// Show the students in sorted order
        System.out.println("\nSorted Data");
        showData(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);
    }
    /**
     * Put elements into arrays (parallel arrays) for ID numbers, names, course,
     year
     levels, prelim grade,
     * midterm grade, tentative final grade, and final grade
     **/
    public static void populateArrays(String[] id, String[] n, String[] c, int[] y, byte[] p, byte[] m, byte[] t, byte[] f) {
        for (int index = 0; index < n.length; index++) {
            System.out.print("Enter the id number of student " + (index + 1) +
                    ":");
            id[index] = keyboard.nextLine();
            System.out.print("Enter the name of student " + (index + 1) + ":");
            n[index] = keyboard.nextLine();
            System.out.print("Enter the course of student " + (index + 1) + ":");
            c[index] = keyboard.nextLine();
            System.out.print("Enter the year level of student " + (index + 1) + ":");
            y[index] = Integer.parseInt(keyboard.nextLine());
            System.out.print("Enter the prelim grade of student " + (index + 1) + ":");
            p[index] = Byte.parseByte(keyboard.nextLine());
            System.out.print("Enter the midterm grade of student " + (index + 1) + ":");
            m[index] = Byte.parseByte(keyboard.nextLine());
            System.out.print("Enter the tentative final grade of student " + (index + 1) + ":");
            t[index] = Byte.parseByte(keyboard.nextLine());

// compute the final grade of student as the average of prelim, midterm and tentative final grade
            f[index] = (byte) ((1.0 * p[index] + 1.0 * m[index] + 1.0 * t[index]) /
                    3.0 + 0.5);
        }
        return;
    }
    /**
     * Sort the elements of the eight arrays in parallel (i.e. When
     * there is a need to swap elements of the array n,
     * the corresponding elements in other arrays should also
     * be swapped.) such that the elements of array n
     * are lexicographically arranged. (SPECIFY the Applied Sort Algorithm
     * that you will follow
     */
    public static void sortDataBasedOnNames(String[] id, String[] n, String[] c, int[] yLevel, byte[] p, byte[] m, byte[] t, byte[] f, int count) {
//TO DO
//Initialize the temp for swapping
        String temp1;
        String temp2;
        String temp3;
        int temp4;
        byte temp5;
        byte temp6;
        byte temp7;
        byte temp8;

//Applying Sort Algorithm
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (n[i].compareTo(n[j]) > 0) {

                    //Swapping names (alphabetical order)
                    temp1 = n[i];
                    n[i] = n[j];
                    n[j] = temp1;

                    //Swapping id
                    temp2 = id[i];
                    id[i] = id[j];
                    id[j] = temp2;

                    //Swapping course
                    temp3 = c[i];
                    c[i] = c[j];
                    c[j] = temp3;

                    //Swapping year level
                    temp4 = yLevel[i];
                    yLevel[i] = yLevel[j];
                    yLevel[j] = temp4;

                    //Swapping prelim grade
                    temp5 = p[i];
                    p[i] = p[j];
                    p[j] = temp5;

                    //Swapping midterm grade
                    temp6 = m[i];
                    m[i] = m[j];
                    m[j] = temp6;

                    //Swapping tentative grade
                    temp7 = t[i];
                    t[i] = t[j];
                    t[j] = temp7;

                    //Swapping final grade
                    temp8 = f[i];
                    f[i] = f[j];
                    f[j] = temp8;
                }
            }
        }
    } // end of sortBasedOnNames method

    /**
     * Show the elements of the arrays on the screen.
     **/
    public static void showData(String[] id, String[] n, String[] c, int[] y, byte[] p, byte[] m, byte[] t, byte[] f) {
        System.out.printf("%-10s%-25s%-10s%-5s%-6s%-6s%-6s%-6s%n", "ID Number", "Name", "Course", "Year", "PG", "MG", "TFG", "FG");
        for (int x = 0; x < n.length; x++)
            System.out.printf("%-10s%-25s%-10s%-5d%-6d%-6d%-6d%-6d%n", id[x], n[x], c[x], y[x], p[x], m[x], t[x], f[x]);
    } // end of showData method
} // end of StudentRecordsViaParallelArrays class

// SAMPLE RUN
    /*
How many student records will be created?2
        Enter the id number of student 1:2233361
        Enter the name of student 1:Hannah Ragudos
        Enter the course of student 1:BSCS
        Enter the year level of student 1:1
        Enter the prelim grade of student 1:87
        Enter the midterm grade of student 1:90
        Enter the tentative final grade of student 1:95
        Enter the id number of student 2:2233362
        Enter the name of student 2:Jereel Simon Necesito
        Enter the course of student 2:BMMA
        Enter the year level of student 2:1
        Enter the prelim grade of student 2:90
        Enter the midterm grade of student 2:94
        Enter the tentative final grade of student 2:92

        Original Order Data
        ID Number Name                     Course    Year PG    MG    TFG   FG
        2233361   Hannah Ragudos           BSCS      1    87    90    95    91
        2233362   Jezreel Simon Necesito   BMMA      1    90    94    92    92

        Sorted Data
        ID Number Name                     Course    Year PG    MG    TFG   FG
        2233361   Hannah Ragudos           BSCS      1    87    90    95    91
        2233362   Jezreel Simon Necesito   BMMA      1    90    94    92    92

     */
