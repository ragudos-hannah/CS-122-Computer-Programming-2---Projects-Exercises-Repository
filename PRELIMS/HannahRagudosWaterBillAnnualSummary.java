/**
 Name: Hannah Ragudos
 Date of Programming:  01/24/2023
 Activity Name: Prelim Exercise 1

 Problem and other specifications:
 (Hypothetical Annual Water Bill Summary Problem )
 The water bills for the 12 months of a year by a water service subscriber is summarized as follows.

 Inputs:
 Water Meter Reading at the beginning of the year (i.e. January 1)
 Water Meter Readings at the end of each of the 12 months
 Payment Rates (Minimum Bill, price of water per cubic meter)

 Outputs:
 Cubic meters of water consumed for each month (monthly consumption)
 Amount paid for each month based on given rates (monthly payment)
 Average of monthly consumptions
 Average of monthly payments
 The month during which the amount of water consumed is highest
 The month during which the amount of water consumed is lowest

 Algorithm:
 1.Read the name of the water consumer (consumer).
 2.Read The classification (cType) of the consumer such that the only valid values for cType is "commercial" or "residential".
 3.Read water meter reading in cubic meters at the beginning of the year(previousR[0]).
 4.For month 1 to 12
 Read the water meter reading in cubic meters at the end of the month (presentR) such
 that presentR cannot be less than previousR. Store the value in an array.
 Compute the volume of water consumed for the month (consumption)
 by subtracting the previousR from presentR. Store the value in an array.
 Compute the amount due (amountDue) from the consumer based on
 the following rules
 If cType is residential and consumption <= 12, the amount due is 180.00
 If cType is residential and consumption > 12, the amount due is 180.00 + (consumption –
 12)*30.00
 If cType is commercial and consumption <= 30, the amount due is 600.00
 If cType is commercial and consumption > 30, the amount due is 600.00 + (consumption –
 30)*50.00
 Store the value in an array.
 5. Determine the average of the monthly water consumptions.
 6. Determine the average of the monthly payments.
 7. Determine the month during which water consumed is highest.
 8. Determine the month during which water consumed is least.
 9. Print the name of the consumer.
 10. Print the consumer type.
 11. Print the water meter reading at the beginning of the year.
 12. Print a table showing the 12 months, water meter readings at
 the end of each month, the amount paid due to the water
 consumption for each month.
 13. Print the average of the monthly water consumptions.
 14. Print the average of the monthly payments.
 15. Print the month during which water consumption is highest.
 16. Print the month during which water consumption is lowest.
 */

// Modify the algorithm/program as you deem necessary

import java.lang.*;
import java.util.Scanner;
public class HannahRagudosWaterBillAnnualSummary {
    /**
     * The code for the main flow of the program
     * */
    public static void main(String[] args){

        int[] presentReading= new int[12];
        int[] startReading= new int[12];
        Scanner kbd = new Scanner(System.in);

        String consumer=""; // to hold name of consumer
        char cType = 'x'; // to hold type of consumer
        int[] nCMUsed = new int[12]; // to hold number of cubic meters of water used for 12 months
        int minCMResidential=12; // to hold cut-off for minimum Bill for residential consumers
        int minCMCommercial=30; // to hold cut-off for minimum Bill for commercial consumers
        double minBillResidential=180.00; // minimum bill for <= 12 Cubic Meters used
        float rateResidential =30.00F; //cost of 1 Cubic Meter above the minimum consumption
        double minBillCommercial=600.00; // minimum bill for <= 20 cubic Meters used
        float rateCommercial =50.00F; //cost of 1 Cubic Meter above the minimum consumption for commercial consumers
        double[] amountDue= new double[12]; // to hold the amount paid for 12 months
        int[] sortedConsumption = new int[12]; // to hold sorted monthly consumption

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String[] sortedMonths =
                {"January","February","March","April","May","June","July", "August", "September",
                        "October", "November", "December"};

        showIntroduction();
        System.out.print("Enter the name of the water consumer: ");
        consumer = kbd.nextLine();
        cType = readTypeOfConsumer();

        startReading[0] = readStartReading(); // invoke readStartReading method
        for (int index=0; index < nCMUsed.length; index++){
            presentReading[index] = readEndOfMonthReading(startReading[index], months[index]);
            //invoke the method for accepting a reading at the end of a month
            if (index < (nCMUsed.length - 1))
                startReading[index+1] = presentReading[index];
            nCMUsed[index] = presentReading[index] - startReading[index];
            amountDue[index] = computeAmountDue(nCMUsed[index], cType,
                    minCMResidential, minBillResidential, minCMCommercial, minBillCommercial,
                    rateResidential, rateCommercial);
        }
        showSummary(consumer, cType, months, startReading, presentReading, nCMUsed, amountDue);
        sortedConsumption = sortArray(nCMUsed, sortedMonths);
        //invoke showArrayElements method to display elements of sortedConsumption and sortedMonths arrays
        System.exit(0);
    } // end of main method

        /**Computes and returns the average of the elements an array of floating point
         numbers*/
        public static double computeAverage(double[] values){
            double total=0; // to hold the total of all elements
            double average=0; // to hold the average
            for (int x=0; x<values.length; x++) // add the elements
                total = total + values[x];
            //compute the average
            average = total/values.length ;
            return average;
        } // end of computeAverage method

        /**Computes and returns the average of the elements an array of integers*/
        public static double computeAverage(int[] values){
            int total=0; // to hold the total of all elements
            double average=0; // to hold the average
            for (int x=0; x<values.length; x++) // add the elements
                total = total + values[x];
            //compute the average
            average = (double) total/values.length;
            return average;
        } // end of computeAverage method

        /**
         *  The following method finds and returns the index of the element with the lowest value
         from an array of positive integers. The Linear Search algorithm is applied.
         */

        //Finds and returns the index of the element with the lowest value from an array of integers
        public static int findLowest(int[] values){
            int result=0; // let lowest be the first element
            for (int x=1; x<values.length; x++) // find out if an element after the first is lower
                if (values[x] < values[result])
                    result = x; //then set the lowest index to the index of lower element
            return result;
        } // end of findLowest method

        //Finds and returns the index of the element with the highest value from an array of integers
        public static int findHighest(int[] values){
            int result=0; // let highest be the first element
            for (int x=1; x<values.length; x++) // find out if an element after the first is higher
                if (values[x] > values[result])
                    result = x; //then set the highest index to the index of higher element
            return result;
        } // end of findHighest method

        /* Displays the menu of this application */
        private static void showIntroduction(){
            System.out.println();
            System.out.println("This program will compose a summary of the annual water consumption of the consumer.");

            System.out.println("\n\t You will be asked to enter the name and type of the consumer,\n\tthe water meter reading at the start of the year,\n\tand the water meter reading at the end of each following months.");
            System.out.println();
            return;
        } // end of showIntroduction method

        /**
         * Read an int type representing a start reading that is entered through the keyboard
         */
        public static int readStartReading(){
            int reading = 0;
            Scanner keyboard = new Scanner(System.in);
            boolean problemFlag = false;
            do {
                problemFlag = false;
                try {
                    System.out.print("Enter the meter reading at the beginning of the year: ");
                    reading = Integer.parseInt(keyboard.nextLine()); // assign a value for reading through the keyboard
                } catch (NumberFormatException x){
                    problemFlag = true;
                    System.out.println("You have to enter a number.");
                }
                if (reading < 0){
                    System.out.println("The beginning meter reading cannot be negative.");
                }
            } while (reading < 0 || problemFlag);
            return reading;
        } // end of readStartReading method

        /** Returns a copy of a given array of integers */
        public static int[] copyArray(int[] arrayGiven){ //
            int[] copy = new int[arrayGiven.length];
            for (int index=0; index<arrayGiven.length; index++)
                copy[index] = arrayGiven[index];
            return copy;
        } // end of copyArray method

        /**
         * Returns an int type that is entered through the keyboard, which represents a meter reading at the end
         of the month, therefore it cannot be less than the given startReading
         * */
        public static int readEndOfMonthReading(int startReading, String month){
            int reading = 0;
            Scanner keyboard = new Scanner(System.in);
            boolean pFlag = false;
            do {
                pFlag = false;
                try {
                    System.out.print("Enter the meter reading for month " + month + " :");
                    reading = Integer.parseInt(keyboard.nextLine());// assigns a value through the keyboard
                } catch (NumberFormatException x){
                    pFlag = true;

                    System.out.println("You have to enter a number.");
                }
                if (reading < startReading){
                    System.out.println("Invalid entry! The present reading must be greater than " + startReading + " , the reading at the start of the month.");
                }
            } while (reading < startReading || pFlag);
            return reading;
        } // end of readEndOfMonthReading method

        /**
         *Returns the character r or c, that is entered through the keyboard, which represents
          the residential or commercial type of consumer
         **/
        public static char readTypeOfConsumer(){
            char t='x';
            Scanner keyboard = new Scanner(System.in);
            do {
                System.out.print("Enter the type of the consumer < you may type r for residential or c for commercial>: ");
                String input = keyboard.nextLine();
                t = input.charAt(0); //assign the first character of input to t
                if (t != 'r' && t !='R' && t != 'c' && t != 'C'){
                    System.out.println("The valid types are r for residential and c for commercial.");
                }
            } while (t != 'r' && t !='R' && t != 'c' && t != 'C');
            return t;
        } // end of readTypeOfConsumer method

        /**
         *Returns a value that represents the amount paid for a month by a consumer with a
         given type, consumption, and values necessary to the computation of an amount due
         */
        public static double computeAmountDue(int c, char t, int min1, double minB1,
                                              int min2, double minB2, float rate1, float rate2){
            double amount = 0;
            switch (t){
                case 'r':
                case 'R':
                    if ( c <= min1 ) {
                        amount = minB1;
                    }
                    else {
                        amount = minB1 + (c-min1)*rate1;
                    }
                    break;
                case 'c':
                case 'C':
                    if ( c <= min2 ) {
                        amount = minB2;
                    }
                    else {
                        amount = minB2 + (c-min2)*rate2;
                    }
            }
            return amount;
        } // end of computeAmountDue method

        /**The selection sort algorithm is used to sort the elements in descending order of an array of
         integers in parallel with an array of strings.
        */
        public static int[] sortArray(int[] array, String[] month){
            int minIndex=0;
            int[] sorted= copyArray(array);
            int temp=0;
            String dummy="";
            for (int x=0; x < sorted.length-1; x++){
                minIndex = x;
                for (int y=x+1; y<sorted.length; y++)
                    if (sorted[minIndex] < sorted[y] )
                        minIndex = y;
                if (minIndex != x){
                    temp = sorted[x];
                    sorted[x] = sorted[minIndex];
                    sorted[minIndex] = temp;
                    dummy = month[x];
                    month[x]= month[minIndex];
                    month[minIndex] = dummy;
                }
            }
            return sorted;
        } // end of sortArray method

        /**
         *Displays a formatted program output
         **/
        public static void showSummary(String n, char t, String[] months, int[]
                previous, int[] present, int[] c, double[] amount){
            System.out.println();
            System.out.println("Annual Water Bill Summary");
            System.out.println("Name of Consumer: " + n);
            System.out.print("Type of consumer: ");
            if (Character.toLowerCase(t) == 'r')
                System.out.println("Residential");
            if (Character.toLowerCase(t) == 'c')
                System.out.println("Commercial");
            System.out.println("Meter reading at the beginning of year = " +
                    previous[0] + " cubic meters");
            System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
            System.out.printf("%15s%15s%15s%20s%n", "Month", "End Reading", "Consumption", "Amount Paid");
            System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
            for (int index=0; index < previous.length; index++){
                System.out.printf("%15s%15d%15d%20.2f%n", months[index], present[index],c[index] , amount[index]);
            }
            System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
            System.out.println("Average Monthly Reading = "+ computeAverage(c) + " cubic meters");
            System.out.println("Average Monthly Payment = "+ computeAverage(amount) );
            // uses a method to get the elements of array amount's average
            System.out.println("Month with Lowest Water Consumption = "+ months[findLowest(c)]);
            System.out.println("Month with Highest Water Consumption = "+ months[findHighest(c)]);
            System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
            return;
        } // end of showSummary method
    } // end of class

// SAMPLE RUN:
    /*
    This program will compose a summary of the annual water consumption of the consumer.

	 You will be asked to enter the name and type of the consumer,
	the water meter reading at the start of the year,
	and the water meter reading at the end of each following months.

Enter the name of the water consumer: Hannah Ragudos
Enter the type of the consumer < you may type r for residential or c for commercial>: r
Enter the meter reading at the beginning of the year: 12
Enter the meter reading for month January :113
Enter the meter reading for month February :132
Enter the meter reading for month March :232
Enter the meter reading for month April :342
Enter the meter reading for month May :453
Enter the meter reading for month June :456
Enter the meter reading for month July :564
Enter the meter reading for month August :657
Enter the meter reading for month September :675
Enter the meter reading for month October :767
Enter the meter reading for month November :889
Enter the meter reading for month December :899

Annual Water Bill Summary
Name of Consumer: Hannah Ragudos
Type of consumer: Residential
Meter reading at the beginning of year = 12 cubic meters
--------------- -------------------------------------------------
          Month    End Reading    Consumption         Amount Paid
--------------- -------------------------------------------------
        January            113            101             2850.00
       February            132             19              390.00
          March            232            100             2820.00
          April            342            110             3120.00
            May            453            111             3150.00
           June            456              3              180.00
           July            564            108             3060.00
         August            657             93             2610.00
      September            675             18              360.00
        October            767             92             2580.00
       November            889            122             3480.00
       December            899             10              180.00
--------------- -------------------------------------------------
Average Monthly Reading = 73.91666666666667 cubic meters
Average Monthly Payment = 2065.0
Month with Lowest Water Consumption = June
Month with Highest Water Consumption = November
--------------- -------------------------------------------------
     */

