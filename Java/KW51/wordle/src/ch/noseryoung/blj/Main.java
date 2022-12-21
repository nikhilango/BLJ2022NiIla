package ch.noseryoung.blj;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Methods.readData();
        String randomWord = Methods.getRandomWord();
        Scanner scan = new Scanner(System.in);

        int tries = 6;
        System.out.println("You have " + tries + " attempts. Good luck!");
        do {
            System.out.println();
            System.out.println("Enter a word: ");
            String enteredWord = scan.nextLine();
            boolean wordInList = Methods.isWordInList(enteredWord);
            do {
                if (wordInList){
                    char[] letterInWord = Methods.isLetterInWord(randomWord, enteredWord);
                    ArrayList<Character> lettersInWord = new ArrayList<>();
                    for (int i = 0; i < 5; i++){
                        if (letterInWord[i] != '*'){
                            lettersInWord.add(letterInWord[i]);
                        }
                    }
                    System.out.println("These letters that are in the word");
                    for (int i = 0; i < lettersInWord.size(); i++){
                        System.out.print(lettersInWord.get(i) + ", ");
                    }
                    System.out.println();
                    //*******************************************************************************
                    char[] letterInCorPos = Methods.isLetterInCorPos(randomWord, enteredWord);
                    ArrayList<Character> lettersInCorPos = new ArrayList<>();

                    for (int i = 0; i < 5; i++){
                        if (letterInCorPos[i] != '*'){
                            lettersInCorPos.add(letterInCorPos[i]);
                        }
                    }
                    int counter = 0;
                    for (int i = 0; i < letterInCorPos.length; i++){
                        if (letterInCorPos[i] == randomWord.charAt(i)){
                            counter++;
                        }
                    }
                    if (counter == 5){
                        System.out.println("YAYYY YOU FOUND THE WORD");
                        return;
                    }
                    System.out.println("These letters are in the correct place in the word");
                    for (int i = 0; i < lettersInCorPos.size(); i++){
                        System.out.print(lettersInCorPos.get(i) + ", ");
                    }
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
