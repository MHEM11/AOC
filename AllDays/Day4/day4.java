package AllDays.Day4;

import AllDays.Generics;

public class day4 {
    public void day4Part1() {
        // Print
        System.out.println("Answers for day 4:");
        //Make object
        Generics readFile = new Generics();
        // Read input file. fileToStringArrayNew splits when meeting a new line ("\n").
        String[] input = readFile.fileToStringArraySpiltWhenNewLine("AllDays/Day4/input.txt");

        int count = 0;
        for (String line : input) {
            if (ContainsAllReqFields(line))
                count++;
        }
        System.out.println(count);
    }
    
    public boolean ContainsAllReqFields(String line) {
        if (line.contains("iyr") && line.contains("pid") && line.contains("eyr") && line.contains("hcl")
                && line.contains("ecl") && line.contains("byr") && line.contains("hgt")) {
                    return true;
        }else{
            return false; 
        }
    }

}
