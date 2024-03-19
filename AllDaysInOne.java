import AllDays.Day1.*;
import AllDays.Day2.*;
import AllDays.Day3.*;
import AllDays.Day4.*;

class MainClass {
    public static void main(String[] args) {
        day1 Day1 = new day1();
        Day1.day1Part1();
        System.out.println("");
        
        day2 Day2 = new day2();
        Day2.day2Part1();
        System.out.println("");

        day3 Day3 = new day3();
        Day3.day3Part1();
        System.out.println("");

        day4 Day4 = new day4();
        Day4.day4Part1();
        System.out.println("");
    }
}