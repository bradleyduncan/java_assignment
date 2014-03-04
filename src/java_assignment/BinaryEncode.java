package java_assignment;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class BinaryEncode {

    public static Double[] CountFile() {

        Double ModeCharCount = 0.0, MeanCharCount = 0.0, WordCount = 0.0, CharCount = 0.0, Counts[] = new Double[4];
        int WordLengths[] = new int[45];

        try {
            BufferedReader Read = new BufferedReader(new FileReader(KeyboardStringInput("a filename")));

            String Line = Read.readLine();
            while (Line != null) {
                String SplitUp[] = Line.split(" ");

                for (String i : SplitUp) {
                    int Length = i.length();

                    WordLengths[Length]++;
                    CharCount += Length;
                    WordCount++;
                }
                Line = Read.readLine();
            }
            MeanCharCount = CharCount / WordCount;

            for (int i = 0; i < 45; i++) {
                if (WordLengths[i] > ModeCharCount) {
                    ModeCharCount = (double) i;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("that file was not found");
            System.exit(0);
        } catch (IOException e) {
            System.exit(0);
        }

        Counts[0] = WordCount;
        Counts[1] = CharCount;
        Counts[2] = MeanCharCount;
        Counts[3] = ModeCharCount;

        return Counts;
    }

    public static String KeyboardStringInput(String Description) {

        Scanner KeyboardScanner = new Scanner(in);
        String UserInput;

        out.println("please enter " + Description);
        UserInput = KeyboardScanner.next();

        return UserInput;
    }

    public static int KeyboardIntInput(String Description) {

        Scanner KeyboardScanner = new Scanner(in);
        int UserInput;

        out.println("please enter " + Description);
        UserInput = KeyboardScanner.nextInt();

        return UserInput;
    }

    public static void ListFiles() {

        File Directory = new File(".");
        String ListFiles = Arrays.toString(Directory.listFiles());

        ListFiles = ListFiles.replace(".\\", "");
        ListFiles = ListFiles.replace("[", "");
        ListFiles = ListFiles.replace("]", "");

        out.println(ListFiles);
    }

    public static void main(String args[]) {
        Double Counts[];
        int Operator, CriticalValue;
        String Selection;

        out.println("The files in this directory are: ");
        ListFiles();

        Counts = CountFile();

        do {
            Selection = KeyboardStringInput("mode or mean");
        }
        while (!(Selection.equals("mode") || Selection.equals("mean")));

        if (Selection.equals("mode")) {
            Operator = 3;
        } else {
            Operator = 2;
        }

        CriticalValue = KeyboardIntInput("a critical value");

        if (Counts[Operator] > CriticalValue) {
            out.println("Heavy");
        } else out.println("Light");
    }
}

