package AllDays.Day2;

import AllDays.Generics;

public class day2 {

    public void day2Part1() {
        // Print
        System.out.println("Answers for day 2:");
        //Make object
        Generics readFile = new Generics();
        // Read input file
        String[] input = readFile.fileToStringArray("AllDays/Day2/input.txt");

        int validCounter = 0;

        for (int i = 0; i < input.length; i++) {
            String[] temp = input[i].split(" ");
            String[] Numbers = temp[0].split("-");
            char letter = temp[1].charAt(0);
            int min = Integer.parseInt(Numbers[0]);
            int max = Integer.parseInt(Numbers[1]);
            int counter = 0;
            char[] letters = temp[2].toCharArray();
            for (char curLetter : letters) {
                if (curLetter == letter) {
                    counter++;
                }
            }
            if (min <= counter && max >= counter) {
                validCounter++;
            }
        }
        System.out.println("Part 1: " + validCounter);
        day2Part2(input);
    }
    
    public void day2Part2(String[] input) {
        
        int validCounter = 0;

        for (int i = 0; i < input.length; i++) {
            String[] temp = input[i].split(" ");
            String[] Numbers = temp[0].split("-");
            char letter = temp[1].charAt(0);
            int pos1 = Integer.parseInt(Numbers[0]);
            int pos2 = Integer.parseInt(Numbers[1]);
            char[] letters = temp[2].toCharArray();
            if ((letters[pos1-1] == letter && letters[pos2-1] != letter) || (letters[pos1-1] != letter && letters[pos2-1] == letter)) {
                validCounter++;
            }
        }
        System.out.println("Part 2: " + validCounter);
    }
}
