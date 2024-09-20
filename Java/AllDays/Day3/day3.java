package AllDays.Day3;

import AllDays.Generics;

public class day3 {
    public void day3Part1() {
        // Print
        System.out.println("Answers for day 3:");
        //Make object
        Generics readFile = new Generics();
        // Read input file
        String[] input = readFile.fileToStringArray("AllDays/Day3/input.txt");
        int treeCounter = 0;
        int place = 0;

        // Go through the input array, while counting encountered trees
        for (int i = 0; i < input.length; i++) {
                if (input[i].charAt(place % input[i].length()) == '#') {
                    treeCounter++;
                }
                place += 3;
        }
        System.out.println("Part 1: " + treeCounter);
        day3Part2(input);
    }

    public void day3Part2(String[] input) {
        // Slopes to check
        int[][] slopes = {
            {1, 1},
            {3, 1},
            {5, 1},
            {7, 1},
            {1, 2}
        };

        long productOfTrees = 1;
        for (int[] slope : slopes) {
            productOfTrees *= countTrees(input, slope[0], slope[1]);
        }

        System.out.println("Part 2: " + productOfTrees);
    }

    public static int countTrees(String[] input, int right, int down) {
        int width = input[0].length();
        int height = input.length;
        int x = 0, y = 0;  // Starting position
        int treeCount = 0;

        while (y < height) {
            if (input[y].charAt(x % width) == '#') {
                treeCount++;
            }
            x += right;
            y += down;
        }
        return treeCount;
    }
}