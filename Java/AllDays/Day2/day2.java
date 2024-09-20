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
        // Counter for valid passwords
        int validCounter = 0;

        for (int i = 0; i < input.length; i++) {
            // Current string split to string array
            String[] temp = input[i].split(" ");
            // first part is numbers separated by "-" therefor we split these into a new string array. They are then parsed into int and set as min/max
            String[] Numbers = temp[0].split("-");
            int min = Integer.parseInt(Numbers[0]);
            int max = Integer.parseInt(Numbers[1]);
            // temp index one is always the letter we search for on index 0 in the string. 
            char letter = temp[1].charAt(0);
            // counter for times letter is in password
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
            // Current string split to string array
            String[] temp = input[i].split(" ");
            // first part is numbers separated by "-" therefor we split these into a new string array. They are then parsed into int and set as position 1 or 2
            String[] Numbers = temp[0].split("-");
            int pos1 = Integer.parseInt(Numbers[0]);
            int pos2 = Integer.parseInt(Numbers[1]);
            char letter = temp[1].charAt(0);
            char[] letters = temp[2].toCharArray();
            // Check if the letter is on position on but not 2 or the other way around
            if ((letters[pos1-1] == letter && letters[pos2-1] != letter) || (letters[pos1-1] != letter && letters[pos2-1] == letter)) {
                validCounter++;
            }
        }
        System.out.println("Part 2: " + validCounter);
    }
}
