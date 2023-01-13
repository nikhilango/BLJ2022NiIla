package ch.noseryoung.blj;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Methods {
    static ArrayList<String> script = new ArrayList<>();

    public static void readData(String path) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scan.hasNextLine()) {
            Scanner scan1 = new Scanner(scan.nextLine());
            while (scan1.hasNext()) {
                String word = scan1.next();
                word = word.toLowerCase().replaceAll("[-,.?!\"]", "");
                if (!word.equals("")) {
                    script.add(word);
                }
            }
        }
    }
    public static void calculateMostCommonWord(String path) {
        int frequency = 0;
        String mostFrequentWord = "";
        for (int i = 0; i < script.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < script.size(); j++) {
                if (script.get(i).equals(script.get(j))) {
                    count++;
                }
            }

            if (count >= frequency) {
                mostFrequentWord = script.get(i);
                frequency = count;
            }
        }
        writeFile(mostFrequentWord, script.size(), path);
    }

    public static int calculateAmountOfMostCommonWord(String path) {
        int frequency = 0;
        String mostFrequentWord = "";
        for (int i = 0; i < script.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < script.size(); j++) {
                if (script.get(i).equals(script.get(j))) {
                    count++;
                }
            }

            if (count >= frequency) {
                mostFrequentWord = script.get(i);
                frequency = count;
            }
        }
        return frequency;
    }

    public static int calculateAmountOfLeastCommonWords(String path) {
        int amountOfUniqueWords = 0;
        Set<String> distinct = new HashSet<>(script);
        for (String s : distinct) {
            if (Collections.frequency(script, s) == 1){
                amountOfUniqueWords++;
            }
        }
        return amountOfUniqueWords;
    }

    public static String calculateLongestWord() {
        String longestWord = "";
        for (int i = 0; i < script.size(); i++) {
            if (script.get(i).length() >= longestWord.length()) {
                longestWord = script.get(i);
            }
        }
        return longestWord;
    }

    public static String wordAdjust(String word) {
        int stringLen = 0;
        for (int i = 0; i < word.length(); i++) {
            stringLen++;
        }
        int charsToAdd = 16 - stringLen;
        for (int i = 0; i < charsToAdd; i++) {
            char space = ' ';
            word = word + space;
        }
        return word;
    }

    public static void writeFile(String mostFrequentWord, int scriptSize, String path) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy / HH:mm:ss");
        Date date = new Date();
        String longestWord = calculateLongestWord();
        int amountOfLeastCommonWords = calculateAmountOfLeastCommonWords(path);
        int amountOfMostCommonWord = calculateAmountOfMostCommonWord(path);
        File file = new File(path);
        String newFileName = file + "_evaluation.txt";
        int jazzIndex = findJazz(scriptSize);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
            writer.write(format.format(date) + "                     " + file.getName());
            writer.write(System.getProperty("line.separator"));
            writer.write("--------------------------------------------------------------");
            writer.write(System.getProperty("line.separator"));
            writer.write("Total number of words:                                    " + scriptSize);
            writer.write(System.getProperty("line.separator"));
            writer.write("Most common word:                   " + mostFrequentWord + ", which comes " + amountOfMostCommonWord + " times");
            writer.write(System.getProperty("line.separator"));
            writer.write("Amount of unique words:                                   " + amountOfLeastCommonWords);
            writer.write(System.getProperty("line.separator"));
            writer.write("The longest word:                         " + longestWord);
            writer.write(System.getProperty("line.separator"));
            if (jazzIndex == 0) {
                writer.write("\"You like Jazz?\" Doesn't exist in this file.");
                writer.write(System.getProperty("line.separator"));
            } else {
                writer.write("\"You like Jazz?\" comes after                        " + (jazzIndex - 2) + " words");
                writer.write(System.getProperty("line.separator"));
            }
            writer.write("--------------------------------------------------------------");
            writer.write(System.getProperty("line.separator"));
            //---------------------------------------------------------------------------------
            for (int i = 0; i < script.size(); i++){
                int stringLen = script.get(i).length();
                String newword = script.get(i);

                int charsToAdd = 61 - stringLen;
                String neededSpaces = "";
                for (int y = 0; y < charsToAdd; y++) {
                    neededSpaces = neededSpaces + " ";
                }
                newword = newword + neededSpaces;
                script.set(i, newword);
            }
            //---------------------------------------------------------------------------------
            Set<String> distinct = new HashSet<>(script);
            for (String s : distinct) {
                writer.write(s + Collections.frequency(script, s));
                writer.write(System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public static int findJazz(int scriptSize) {
        for (int i = 0; i < scriptSize; i++) {
            if (script.get(i).equals("jazz")) {
                return i;
            }
        }
        return 0;
    }
}
