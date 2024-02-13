/**
 Name: Hannah Ragudos
 Date of Programming:  02/03/2023
 Activity Name: Prelim Exercise 4

 Problem and other specifications:
 Create a similar application program. Include appropriate data members for your Student
 class (i.e. modify the given examples). Show a sample output of your application.

 First Approach: Use parallel arrays
 Second Approach: Use an array (one dimensional array) of objects
 */


package prelims;

import java.util.Scanner;
public class HannahRagudosStudentClass {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Student[] list;
        int number;
        System.out.print("How many students will be listed? ");
        number = Integer.parseInt(keyboard.nextLine());
        list = new Student[number];
        System.out.println("Enter the student information.");
        for (int x = 0; x < list.length; x++) {
            System.out.println("For student " + (x + 1) + " :");
            list[x] = readStudent();
        }
        System.out.println();
        System.out.println("Unsorted List");
        System.out.println(String.format("%20s %20s %20s %20s %20s", "First Name", "Middle Name", "Last Name", "Age", "Grade Point Average"));
        showList(list);
        System.out.println();
        System.out.println("Sorted List");
        System.out.println(String.format("%20s %20s %20s %20s %20s", "First Name", "Middle Name", "Last Name", "Age", "Grade Point Average"));
        sortList(list);
        showList(list);
        System.exit(0);
    }
    private static void showList(Student[] studs) {
        for (int x = 0; x < studs.length; x++)
            System.out.println(studs[x].toString());
    }
    private static Student readStudent() {
        System.out.print("first name: ");
        String f = keyboard.nextLine();

        System.out.print("middle name: ");
        String m = keyboard.nextLine();

        System.out.print("last name: ");
        String l = keyboard.nextLine();

        System.out.print("age: ");
        int a = Integer.parseInt(keyboard.nextLine());

        System.out.print("grade point average: ");
        double g = Double.parseDouble(keyboard.nextLine());

        Student s = new Student(f, m, l, a, g);
        return s;
    }
    // Warning! using the last name as the sort key is not sufficient for a realistic set of records
    // This method needs improvement
    public static void sortList(Student[] s) {
        Student temp;
        int minIndex = 0;
        for (int x = 0; x < s.length - 1; x++) {
            minIndex = x;
            for (int y = x + 1; y < s.length; y++) {
                if
                (s[minIndex].getLastName().compareToIgnoreCase(s[y].getLastName()) > 0)
                    minIndex = y;
                if
                (s[minIndex].getMidName().compareToIgnoreCase(s[y].getMidName())> 0)
                minIndex = y;
            }
            if (minIndex != x) {
                temp = s[x];
                s[x] = s[minIndex];
                s[minIndex] = temp;
            }
        }
    }
    public static class Student {
        private String firstName = "";
        private String midName = "";
        private String lastName = "";
        private int age;
        private double gPA;

        public Student(String s, String firstName, String midName, String lastName, int a, double g) {
            super();

            this.firstName = firstName;
            this.midName = midName;
            this.lastName = lastName;
        }
        public Student(String f, String m, String l, int a, double g) {
            firstName = f;
            midName = m;
            lastName = l;
            age = a;
            gPA = g;
        }
        public String getFirstName() {

            return firstName;
        }
        public String getMidName() {
            return midName;
        }
        public String getLastName() {

            return lastName;
        }
        public int getAge() {

            return age;
        }
        public double getgPA() {

            return gPA;
        }

        public void setFirstName(String firstName) {

            this.firstName = firstName;
        }
        public void setMidName(String midName) {

            this.midName = midName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setAge(int a) {

            age = a;
        }
        public void setgPA(double g) {

            gPA = g;
        }

        public String toString() {
            System.out.println(String.format("%20s %20s %20s %20s %20s", firstName, midName, lastName, age, gPA));
            return String.valueOf(new char[0]);
        }


        public boolean equals(Student other) {
            boolean r = false;
            r = (firstName.equalsIgnoreCase(other.getFirstName()));
            if (this == other)
                return true;
            if (other == null)
                return false;
            if (getClass() != other.getClass())
                return false;
            if (firstName == null)
                return false;
            else if (!firstName.equals(other.firstName))
                return false;
            if (midName == null)
                return false;
            else if (!midName.equals(other.midName))
                return false;
            if (lastName == null) {
                if (other.lastName != null)
                    return false;
            }else if (!lastName.equals(other.lastName))
                return false;
            return r;
        }
    }
}

// SAMPLE RUN
/*
Enter the student information.
For student 1 :
first name: Mark
middle name: Lee
last name: Kuan
age: 25
grade point average: 92.30
For student 2 :
first name: Carla
middle name: Park
last name: Somi
age: 24
grade point average: 88.90
For student 3 :
first name: Anne
middle name: Dimo
last name: Lopez
age: 23
grade point average: 90.87
For student 4 :
first name: Juan
middle name: Abad
last name: Cruz
age: 24
grade point average: 91.25

Unsorted List
          First Name          Middle Name            Last Name                  Age  Grade Point Average
                Mark                  Lee                 Kuan                   25                 92.3

               Carla                 Park                 Somi                   24                 88.9

                Anne                 Dimo                Lopez                   23                90.87

                Juan                 Abad                 Cruz                   24                91.25


Sorted List
          First Name          Middle Name            Last Name                  Age  Grade Point Average
                Juan                 Abad                 Cruz                   24                91.25

                Mark                  Lee                 Kuan                   25                 92.3

                Anne                 Dimo                Lopez                   23                90.87

               Carla                 Park                 Somi                   24                 88.9
 */
