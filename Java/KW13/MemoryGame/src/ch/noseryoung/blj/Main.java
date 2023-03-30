package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> revealedWords = new ArrayList<>();
        String[][] uncoveredField = new String[6][6];
        String[][] coveredField = new String[6][6];
        for (int i = 0; i < 6; i++){
            for (int a = 0; a < 6; a++){
                coveredField[i][a] = "*****";
            }
        }
        ArrayList<String> words = new ArrayList<>();
        words.add("Flaky");
        words.add("Jazzy");
        words.add("Fable");
        words.add("Crisp");
        words.add("Swoop");
        words.add("Gloom");
        words.add("Hippy");
        words.add("Plush");
        words.add("Grasp");
        words.add("Munch");
        words.add("Glaze");
        words.add("Quirk");
        words.add("Bumpy");
        words.add("Sable");
        words.add("Chirp");
        words.add("Braid");
        words.add("Thump");
        words.add("Coozy");
        words.add("Flaky");
        words.add("Jazzy");
        words.add("Fable");
        words.add("Crisp");
        words.add("Swoop");
        words.add("Gloom");
        words.add("Hippy");
        words.add("Plush");
        words.add("Grasp");
        words.add("Munch");
        words.add("Glaze");
        words.add("Quirk");
        words.add("Bumpy");
        words.add("Sable");
        words.add("Chirp");
        words.add("Braid");
        words.add("Thump");
        words.add("Coozy");
        Collections.shuffle(words);
        Methods.initMemoryWords(words, uncoveredField);
        for (int i = 0; i < 6; i++){
            for (int a = 0; a < 6; a++){
                System.out.print(" | " + uncoveredField[i][a]);
            }
            System.out.println(" | \n");
        }
        for (int i = 0; i < 6; i++){
            for (int a = 0; a < 6; a++){
                System.out.print(" | " + coveredField[i][a]);
            }
            System.out.println(" | \n");
        }
        System.out.println("Select a coordinate to reveal the word:");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        coveredField[x1][y1] = uncoveredField[x1][y1];
        for (int i = 0; i < 6; i++){
            for (int a = 0; a < 6; a++){
                System.out.print(" | " + coveredField[i][a]);
            }
            System.out.println(" | \n");
        }
        System.out.println("Select a coordinate to reveal the second word:");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        coveredField[x2][y2] = uncoveredField[x2][y2];
        for (int i = 0; i < 6; i++){
            for (int a = 0; a < 6; a++){
                System.out.print(" | " + coveredField[i][a]);
            }
            System.out.println(" | \n");
        }
        if (coveredField[x1][y1].equals(uncoveredField[x2][y2])){
            System.out.println("Congratulations you have found the same words!");
            revealedWords.add(uncoveredField[x2][y2]);
        }
        else {
            System.out.println("I'm sorry the words don't match!");
            coveredField[x1][y1] = "*****";
            coveredField[x2][y2] = "*****";
        }
        for (int i = 0; i < 6; i++){
            for (int a = 0; a < 6; a++){
                System.out.print(" | " + coveredField[i][a]);
            }
            System.out.println(" | \n");
        }
    }
}