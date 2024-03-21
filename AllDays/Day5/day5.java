package AllDays.Day5;

import java.util.Arrays;

import AllDays.Generics;

public class day5 {
    public void day5Part1() {
        // Print
        System.out.println("Answers for day 5:");
        //Make object
        Generics readFile = new Generics();
        // Read input file. fileToStringArrayNew splits when meeting a new line ("\n").
        String[] input = readFile.fileToStringArray("AllDays/Day5/input.txt");

        int lowestRow = 0;
        int highestRow = 127;
        int lowestSeatNumber = 0;
        int highestSeatNumber = 7;
        int seatNumber = -1;
        int rowNumber = -1;
        
        boolean[][] seats = new boolean[128][8];
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 8; j++) {
                seats[i][j] = false;
            }
        }
        for (String line : input) {
            char[] lineInChars = line.toCharArray();
            for (int k = 0; k <= 6; k++) {
                if (lineInChars[k] == 'F') {
                    highestRow = lowestRow + (highestRow - lowestRow) / 2;
                } else if (lineInChars[k] == 'B') {
                    lowestRow = lowestRow + (highestRow - lowestRow) / 2 + 1;
                }
            }
            rowNumber = lowestRow;
            
            for (int i = 7; i < lineInChars.length; i++) {
                if (lineInChars[i] == 'L') {
                    highestSeatNumber = lowestSeatNumber + (highestSeatNumber - lowestSeatNumber)/2;
                } else if (lineInChars[i] == 'R') {
                    lowestSeatNumber = lowestSeatNumber + (highestSeatNumber - lowestSeatNumber)/2 + 1;
                }
            }
            seatNumber = lowestSeatNumber;

            if (seatNumber > -1 && rowNumber > -1) {
                seats[rowNumber][seatNumber] = true;
                seatNumber = -1;
                rowNumber = -1;
                lowestRow = 0;
                highestRow = 127;
                lowestSeatNumber = 0;
                highestSeatNumber = 7;
            }
        }
        int max = 0;
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 8; j++) {
                if (seats[i][j] == true) {
                    max = (i * 8) + j;
                }
            }
        }
        System.out.println("Part 1: " + max);
        int yourSeatid = day5Part2(input);
        System.out.println("Part 2: " + yourSeatid);
    }

    private int day5Part2(String[] input) {
        int lowestRow = 1;
        int highestRow = 126;
        int lowestSeatNumber = 0;
        int highestSeatNumber = 7;
        int seatNumber = -1;
        int rowNumber = -1;
        
        int[] seatIDs = new int[input.length];
        int placeholder = 0;
        for (String line : input) {
            char[] lineInChars = line.toCharArray();
            for (int k = 0; k <= 6; k++) {
                if (lineInChars[k] == 'F') {
                    highestRow = lowestRow + (highestRow - lowestRow) / 2;
                } else if (lineInChars[k] == 'B') {
                    lowestRow = lowestRow + (highestRow - lowestRow) / 2 + 1;
                }
            }
            rowNumber = lowestRow;
            
            for (int i = 7; i < lineInChars.length; i++) {
                if (lineInChars[i] == 'L') {
                    highestSeatNumber = lowestSeatNumber + (highestSeatNumber - lowestSeatNumber)/2;
                } else if (lineInChars[i] == 'R') {
                    lowestSeatNumber = lowestSeatNumber + (highestSeatNumber - lowestSeatNumber)/2 + 1;
                }
            }
            seatNumber = lowestSeatNumber;

            if (seatNumber > -1 && rowNumber > -1) {
                seatIDs[placeholder] = rowNumber*8+seatNumber;
                seatNumber = -1;
                rowNumber = -1;
                lowestRow = 0;
                highestRow = 127;
                lowestSeatNumber = 0;
                highestSeatNumber = 7;
                placeholder++;
            }
        }
        int yourSeatID = 0;
        Arrays.sort(seatIDs);
        for (int i = 0; i < seatIDs.length - 1; i++) {
            if (seatIDs[i + 1] - seatIDs[i] == 2) {
                yourSeatID = seatIDs[i] + 1;
            }
        }
        return yourSeatID;
    }
}