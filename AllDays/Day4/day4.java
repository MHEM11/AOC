package AllDays.Day4;

import AllDays.Generics;

// !NOTE! For this exercise i used chatGPT to generate code snippets

public class day4 {
    public void day4Part1() {
        // Print
        System.out.println("Answers for day 4:");
        //Make object
        Generics readFile = new Generics();
        // Read input file. fileToStringArrayNew splits when meeting a new line ("\n").
        String[] input = readFile.fileToStringArraySpiltWhenNewLine("AllDays/Day4/input.txt");

        int count1 = 0;
        int count2 = 0;
        for (String line : input) {
            if (ContainsAllReqFields(line))
                count1++;
            Passport passport = Passport.parse(line);
                if (passport != null && passport.isValid()) {
                    count2++;
                }
        }
        System.out.println("Part 1: " + count1);
        System.out.println("Part 2: " + count2);
    }

    public boolean ContainsAllReqFields(String line) {
        if (line.contains("iyr") && line.contains("pid") && line.contains("eyr") && line.contains("hcl")
                && line.contains("ecl") && line.contains("byr") && line.contains("hgt")) {
            return true;
        } else {
            return false;
        }
    }

}

class Passport {
    String byr, iyr, eyr, hgt, hcl, ecl, pid;
    
    public static Passport parse(String data) {
        Passport passport = new Passport();
        String[] fields = data.split("\\s+");
        for (String field : fields) {
            String[] keyValue = field.split(":");
            if (keyValue.length == 2) {
                switch (keyValue[0]) {
                    case "byr": passport.byr = keyValue[1]; break;
                    case "iyr": passport.iyr = keyValue[1]; break;
                    case "eyr": passport.eyr = keyValue[1]; break;
                    case "hgt": passport.hgt = keyValue[1]; break;
                    case "hcl": passport.hcl = keyValue[1]; break;
                    case "ecl": passport.ecl = keyValue[1]; break;
                    case "pid": passport.pid = keyValue[1]; break;
                    // Ignore 'cid'
                }
            }
        }
        return passport;
    }
    
    public boolean isValid() {
        return isValidByr() && isValidIyr() && isValidEyr() && isValidHgt() && isValidHcl() && isValidEcl() && isValidPid();
    }

    private boolean isValidByr() { return byr != null && byr.matches("\\d{4}") && Integer.parseInt(byr) >= 1920 && Integer.parseInt(byr) <= 2002; }
    private boolean isValidIyr() { return iyr != null && iyr.matches("\\d{4}") && Integer.parseInt(iyr) >= 2010 && Integer.parseInt(iyr) <= 2020; }
    private boolean isValidEyr() { return eyr != null && eyr.matches("\\d{4}") && Integer.parseInt(eyr) >= 2020 && Integer.parseInt(eyr) <= 2030; }
    private boolean isValidHgt() {
        if (hgt == null) return false;
        if (hgt.endsWith("cm")) {
            int cm = Integer.parseInt(hgt.replace("cm", ""));
            return cm >= 150 && cm <= 193;
        } else if (hgt.endsWith("in")) {
            int inches = Integer.parseInt(hgt.replace("in", ""));
            return inches >= 59 && inches <= 76;
        }
        return false;
    }
    private boolean isValidHcl() { return hcl != null && hcl.matches("#[0-9a-f]{6}"); }
    private boolean isValidEcl() { return ecl != null && ecl.matches("amb|blu|brn|gry|grn|hzl|oth"); }
    private boolean isValidPid() { return pid != null && pid.matches("\\d{9}"); }
}
