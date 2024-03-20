package csc145exam2;
/**
 * File: MyArray.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 03/07/2024
 * Java class description: Creates 2D array with random values | Prints Array | Shuffles Array
 */
import java.util.Random;

public class MyArray {
    // THIS IS FOR FORMATTING OUTPUT
    static int maxDigit;

    public static int[][] getArray2D(int rows, int columns, int minNum, int maxNum){
        // Sets maxGenerated to lowest possible int for formatting
        int maxGenerated = (int)Double.NEGATIVE_INFINITY;
        // Creates an int 2D array that has x amount of rows and y amount of columns
        int [][] result = new int[rows][columns];
        // Creates Random object
        Random rand = new Random();
        // Loops through each row
        for (int i = 0;i < rows; i++) {
            // Loops through each column in i row
            for (int j = 0; j < columns; j++) {
               // Gives random value between minNum - maxNum range to
               result[i][j] = rand.nextInt(maxNum-minNum + 1) + minNum; // Adds 1 because inclusive
               // If new generated num is higher than maxGenerated assigns num to maxGenerated
               if (result[i][j] > maxGenerated) {
                   maxGenerated = result[i][j];
               }
            }
        }
        // Sets maxDigit to the num of digits the highest generated num had
        maxDigit = Integer.toString(maxGenerated).length();
        return result;
    }

    private static String getStringHelper(int value, boolean mode, int iteration, String delimiterLeft1, String delimiterRight1, String delimiterLeft2, String delimiterRight2){
        // Turns int value to string for simplicity sake
        String valueAsString = "" + value;
        // Corrects the number to have enough spaces to maintain format
        while (valueAsString.length() != maxDigit){
            valueAsString = " " + valueAsString;
        }
        String formatString = "";
        if (mode){
            if (iteration % 2 == 0){
                formatString += delimiterLeft1 + valueAsString + delimiterRight1 + " ";
            } else {
                formatString += delimiterLeft2 + valueAsString + delimiterRight2 + " ";
            }
        } else {
            if (iteration % 2 == 0){
                formatString += delimiterLeft2 + valueAsString + delimiterRight2 + " ";
            } else {
                formatString += delimiterLeft1 + valueAsString + delimiterRight1 + " ";
            }
        }
        return formatString;
    }

    public static String getString(int[][] array, boolean mode, String delimiterLeft1, String delimiterRight1, String delimiterLeft2, String delimiterRight2){
        // Sets str to empty string
        String str = "";
        // To track which delimiter to use
        int iteration = 0;
        // Loops through the outer array
        for (int i = 0;i < array.length; i++) {
            // Loops through the inner array
            for (int j = 0; j < array[i].length; j++) {
                // Adds value to the string with a space surrounded by delimiter chosen based on mode
                str += getStringHelper(array[i][j], mode, iteration, delimiterLeft1, delimiterRight1, delimiterLeft2, delimiterRight2);
                iteration += 1;
            }
            // End of row so add line break
            str += "\n";
        }
        // Adds concatenated string
        return str;
    }

    public static void shuffleArray(int[][] array){
        // *** SWAPS ROWS ***
        // Creates a helper array to store array during swap
        int[] helperArray;
        // Loops through outer array (rows)
        for (int i = 0 ; i < array.length ; i++){
            // Checks if row should be swapped
            if (i%2 == 0 && array.length - 1 > i ) {
                // Swaps the even and odd rows
                helperArray = array[i];
                array[i] = array[i+1];
                array[i+1] = helperArray;
            }
        }
        // *** SWAPS COLUMNS ***
        // var to store column value for swapping
        int helperNum;
        // Loops through columns
        for (int i = 0 ; i < array[0].length ; i++) {
            // Checks if column should be swapped
            if (i % 2 == 0 && array[0].length - 1 > i ) {
                // Swaps the even and odd columns
                for (int j = 0; j < array.length; j++){
                    helperNum = array[j][i];
                    array[j][i] = array[j][i+1];
                    array[j][i+1] = helperNum;
                }
            }
        }
    }
}
