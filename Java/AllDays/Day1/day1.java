package AllDays.Day1;

import AllDays.*;

public class day1 {
    public void day1Part1() {
        // Print
        System.out.println("Answers for day 1:");
        //Make object
        Generics readFile = new Generics();
        // Read input file
        String[] input = readFile.fileToStringArray("AllDays/Day1/input.txt");
        // Makes an int array to store the converted string array in
        int[] inputAsInt = new int[input.length];
        // make index for 
        int index = 0;
        // Boolean value that is true when answer is found
        boolean found = false;

        // covert every string in input array to int and put them into int array (inputAsInt)
        for (String line : input) {
            try {
                inputAsInt[index] = Integer.parseInt(line);
                index++;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + line + " is not a valid integer.");
            }
        }

        // go throug the input and check if it is the correct values
        for (int i = 0; i < inputAsInt.length; i++) {
            for (int j = 0; j < inputAsInt.length; j++) {
                if (inputAsInt[i] + inputAsInt[j] == 2020) {
                    System.out.println("Part 1: " + (inputAsInt[i] * inputAsInt[j]));
                    // As there only is one true answer one can short circuit the loop by breaking if values are found
                    found = true;
                }
                if (found == true)
                    break;
            }
            if (found == true)
                break;
        }
        day1Part2(inputAsInt);
    }

    public void day1Part2(int[] inputAsInt) {
        // Boolean value that is true when answer is found
        boolean found = false;

        // go throug the input and check if it is the correct values
        for (int i = 0; i < inputAsInt.length; i++) {
            for (int j = 0; j < inputAsInt.length; j++) {
                for (int k = 0; k < inputAsInt.length; k++) {
                    if (inputAsInt[i] + inputAsInt[j] + inputAsInt[k] == 2020) {
                        System.out.println("Part 2: " + (inputAsInt[i] * inputAsInt[j] * inputAsInt[k]));
                        // As there only is one true answer one can short circuit the loop by breaking if values are found
                        found = true;
                    }
                    if (found == true)
                        break;
                }
                if (found == true)
                    break;
            }
        }
    }
}


