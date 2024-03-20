package csc145exam2;
/**
 * File: Main.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 03/07/2024
 * Java class description: Driver class used to showcase MyArray class methods
 */
public class Main {

    public static void showcaseArray(int[][] array, boolean mode){
        // Returns a string to visualize array
        System.out.println("BEFORE SWAP:");
        System.out.println(MyArray.getString(array, mode, "[", "]", "(", ")"));
        // Shuffles the array by swapping rows then columns
        MyArray.shuffleArray(array);
        System.out.println("AFTER SWAP:");
        // Returns a string to visualize array
        System.out.println(MyArray.getString(array, mode, "[", "]", "(", ")"));
    }

    public static void main(String[] args) {
        // Params : # Rows, # Columns, Min #, Max #
        showcaseArray(MyArray.getArray2D(5, 5, 0, 10), true);

        showcaseArray(MyArray.getArray2D(5, 5, 0, 100), true);

        showcaseArray(MyArray.getArray2D(5, 5, 0, 1000), true);

        showcaseArray(MyArray.getArray2D(5, 5,  0, 10000), true);
    }
}
