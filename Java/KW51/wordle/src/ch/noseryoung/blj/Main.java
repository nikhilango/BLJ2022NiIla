package ch.noseryoung.blj;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String RESET = "\033[0m";
    static String[][] field = new String[6][5];
    public static void main(String[] args) {
        Methods.readData();
        String randomWord = Methods.getRandomWord();
        Scanner scan = new Scanner(System.in);
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 5; i++) {
                field[j][i] = " ";
            }
        }
        int col = 0;
        int tries = 6;
        System.out.println("You have " + tries + " attempts. Good luck!");
        do {
            System.out.println();
            System.out.println("Enter a word: ");
            String enteredWord = scan.nextLine();
            boolean wordInList = Methods.isWordInList(enteredWord);
            do {
                if (wordInList){
                    String[] letterInWord = Methods.isLetterInWord(randomWord, enteredWord);
                    ArrayList<String> lettersInWord = new ArrayList<>();
                    for (int i = 0; i < 5; i++){
                        lettersInWord.add(letterInWord[i]);
                    }
                    System.out.println();
                    //*******************************************************************************
                    String[] letterInCorPos = Methods.isLetterInCorPos(randomWord, letterInWord);
                    if (randomWord.equals(enteredWord)){
                        System.out.println("YAYYY YOU FOUND THE WORD");
                        return;
                    }
                    for (int j = 0; j < col + 1; j++) {
                        for (int i = 0; i < letterInCorPos.length; i++) {
                            field[col][i] = letterInCorPos[i];
                        }
                    }
                    System.out.println("+-------------------+");
                    for (int j = 0; j < 6; j++){
                        System.out.print("| ");
                        for (int i = 0; i < letterInCorPos.length; i++){
                            System.out.print(field[j][i] + " | ");
                        }
                        System.out.println();
                        System.out.println("+-------------------+");
                    }

                    col++;
                    System.out.println();
                    tries--;
                    System.out.println("You have " + tries + " attempts left.");
                }
                else {
                    System.out.println("This word does not exist, please try again.");
                    wordInList = true;
                }
            }while (!wordInList);
        }while (tries != 0);
        System.out.println("The word was " + randomWord);
    }
}
