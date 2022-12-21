package ch.noseryoung.blj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Methods {
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String RESET = "\033[0m";  // Text Reset
    static ArrayList<String> words = new ArrayList<>();
    public static void readData(){
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/ch/noseryoung/blj/wordList.txt"));
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                words.add(values[0]);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRandomWord(){
        Random r = new Random();
        int randomIndex = r.nextInt(words.size() - 0) + 0;
        return words.get(randomIndex);
    }

    public static boolean isWordInList(String enteredWord) {
        boolean existence = false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(enteredWord)) {
                existence = true;
            }
        }
        if (!existence){
            return false;
        }
        return true;
    }
    public static char[] isLetterInWord(String randomWord, String enteredWord){
        char[] lettersInWord2 = new char[5];
        for (int i = 0; i < 5; i++){
            String charToString = Character.toString(enteredWord.charAt(i));
            if (randomWord.contains(charToString)){
                lettersInWord2[i] = enteredWord.charAt(i);
            }
            else {
                lettersInWord2[i] = '*';
            }
        }
        return lettersInWord2;
    }
    public static char[] isLetterInCorPos(String randomWord, String enteredWord){
        char[] lettersInWord = new char[5];
        for (int i = 0; i < randomWord.length(); i++){
            if (randomWord.charAt(i) == enteredWord.charAt(i)){
                lettersInWord[i] = randomWord.charAt(i);
            }
            else{
                lettersInWord[i] = '*';
            }
        }

        return lettersInWord;
    }
}
