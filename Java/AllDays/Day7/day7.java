package AllDays.Day7;

import AllDays.Generics;

public class day7 {
    public void DAY7()
    {
        // Print
        System.out.println("Answers for day 7:");
        //Make object
        Generics readFile = new Generics();
        // Read input file. fileToStringArrayNew splits when meeting a new line ("\n").
        String[] input = readFile.fileToStringArray("AllDays/Day7/input.txt");

        String[] ContainsYourBag = new String[10];
        for (String line : input) {
            String[] split = line.split("contain");
            System.out.println(split[0]);
        }
    }}
