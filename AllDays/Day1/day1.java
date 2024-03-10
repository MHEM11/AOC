package AllDays.Day1;

import AllDays.*;

public class day1 {
    public void day1Part1() {
        Generics readFile = new Generics();
        String[] input = readFile.fileToStringArray("AllDays/Day1/input.txt");
        int[] inputAsInt = new int[input.length];
        int index = 0;

        for (String line : input) {
            try {
                inputAsInt[index] = Integer.parseInt(line);
                index++;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + line + " is not a valid integer.");
            }
        }

        for (int i = 0; i < inputAsInt.length; i++) {
            for (int j = 0; j < inputAsInt.length; j++) {
                for (int k = 0; k < inputAsInt.length; k++) {
                    if (inputAsInt[i] + inputAsInt[j] + inputAsInt[k] ==2020) {
                        System.out.println(inputAsInt[i] * inputAsInt[j] * inputAsInt[k]);
                    }
                }
            }
        }
    }
}
