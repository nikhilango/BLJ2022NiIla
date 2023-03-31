package ch.noseryoung.blj;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> revealedWords = new ArrayList<>();
        String[][] uncoveredField = new String[6][6];
        String[][] coveredField = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int a = 0; a < 6; a++) {
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
        int turnCounter = 0;
        boolean won;
        while (true) {
            System.out.println("\n  +---0---+---1---+---2---+---3---+---4---+---5---+");
            for (int i = 0; i < 6; i++) {
                System.out.print(i);
                for (int a = 0; a < 6; a++) {
                    System.out.print(" | " + uncoveredField[i][a]);
                }
                System.out.println(" | \n");
            }
            System.out.println("  +-------+-------+-------+-------+-------+-------+");
            Methods.printField(coveredField);
            boolean passed1 = true;
            int x1 = 0;
            int y1 = 0;
            do {
                System.out.println("Select a coordinate to reveal the word:");
                x1 = scan.nextInt();
                y1 = scan.nextInt();
                if (!Methods.coordinateCheck(x1, y1)){
                    passed1 = false;
                }
                else {
                    passed1 = true;
                }
                for (int i = 0; i < revealedWords.size(); i++) {
                    if (uncoveredField[x1][y1].equals(revealedWords.get(i))) {
                        passed1 = false;
                    } else {
                        passed1 = true;
                    }
                }
                if (!passed1) {
                    System.out.println("You have already uncovered this word!");
                }

            } while (!passed1);
            coveredField[x1][y1] = uncoveredField[x1][y1];
            Methods.printField(coveredField);

            boolean passed2 = true;
            int x2 = 0;
            int y2 = 0;
            do {
                System.out.println("Select a coordinate to reveal the second word:");
                x2 = scan.nextInt();
                y2 = scan.nextInt();
                if (!Methods.coordinateCheck(x2, y2)){
                    passed2 = false;
                }
                else {
                    passed2 = true;
                }
                for (int i = 0; i < revealedWords.size(); i++) {
                    if (uncoveredField[x2][y2].equals(revealedWords.get(i)) || (x1 == x2 && y1 == y2)) {
                        passed2 = false;
                    } else {
                        passed2 = true;
                    }
                }
                if (!passed2) {
                    System.out.println("You have already uncovered this word!");
                }


            } while (!passed2);

            coveredField[x2][y2] = uncoveredField[x2][y2];
            Methods.printField(coveredField);
            if (coveredField[x1][y1].equals(uncoveredField[x2][y2])) {
                System.out.println("Congratulations you have found the same words!");
                revealedWords.add(uncoveredField[x2][y2]);
            } else {
                System.out.println("I'm sorry the words don't match!");
                coveredField[x1][y1] = "*****";
                coveredField[x2][y2] = "*****";
            }
            won = false;
            turnCounter++;
            if (turnCounter >= 18 && Arrays.deepEquals(coveredField, uncoveredField)) {
                won = true;
                break;
            }
        }
        if (won){
            System.out.println("CONGRATULATIONS YOU HAVE SOLVE THE MEMORY!!");
        }
    }
}