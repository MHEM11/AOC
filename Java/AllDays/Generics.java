package AllDays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Generics {
    public String[] fileToStringArray(String fileName) {
        List<String> linesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert the ArrayList to an Array
        String[] linesArray = linesList.toArray(new String[0]);
        return linesArray;
    }

    public String[] fileToStringArraySpiltWhenNewLine(String fileName) {
        List<String> linesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String temp = "";
                while ((line = reader.readLine()) != null) {
                    if (line.length() > 0) {
                        temp += line;
                        temp += " ";
                    } else if (line.length() == 0) {
                        linesList.add(temp);
                        temp = "";
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert the ArrayList to an Array
        String[] linesArray = linesList.toArray(new String[0]);
        return linesArray;
    }
}
