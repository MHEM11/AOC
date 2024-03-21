package AllDays.Day6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import AllDays.Generics;

public class day6 {
    public void day6Part1() {
        // Print
        System.out.println("Answers for day 6:");
        //Make object
        Generics readFile = new Generics();
        // Read input file. fileToStringArrayNew splits when meeting a new line ("\n").
        String[] input = readFile.fileToStringArraySpiltWhenNewLine("AllDays/Day6/input.txt");

        int counter = 0;
        for (String line : input) {
            line = line.replace(" ", "");

            String yesCountString = "";
            for (char letter : line.toCharArray()) {
                if (!yesCountString.contains(String.valueOf(letter))) {
                    yesCountString += letter;
                }
            }
            counter += yesCountString.length();
        }
        System.out.println("Part 1: " + counter);
        day6Part2(input);

    }
    
    public void day6Part2(String[] input) {
        int counter = 0;
        boolean ExistsInPrevAnswers = true;

        for (String line : input) {
            String yesCountString = "";
            String[] AnswerArray = line.split(" ");
            if (AnswerArray.length < 2) {
                counter += AnswerArray[0].length();
            } else {
                for (int i = 0; i < AnswerArray.length; i++) {
                    for (int j = 0; j < AnswerArray[i].length(); j++) {
                        ExistsInPrevAnswers = true;
                        for (int k = 0; k < AnswerArray.length; k++) {
                            if (k != i && ExistsInPrevAnswers) {
                                if (!AnswerArray[k].contains(String.valueOf(AnswerArray[i].charAt(j)))) {
                                    yesCountString = yesCountString.replace(String.valueOf(AnswerArray[i].charAt(j)), "");
                                    ExistsInPrevAnswers = false;
                                } else if (AnswerArray[k].contains(String.valueOf(AnswerArray[i].charAt(j)))
                                        && !yesCountString.contains(String.valueOf(AnswerArray[i].charAt(j)))) {
                                    yesCountString += AnswerArray[i].charAt(j);
                                }
                            }
                        }
                    }
                }
            }
            counter += yesCountString.length();
        }
        System.out.println("Part 2: " + counter);
    }
}