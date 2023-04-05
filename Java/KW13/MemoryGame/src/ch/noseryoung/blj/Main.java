package ch.noseryoung.blj;
import java.util.ResourceBundle;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> revealedWords = new ArrayList<>();
        String[][] uncoveredField = new String[6][6];
        String[][] coveredField = new String[6][6];
        coveredField = Methods.initCoveredfield(coveredField);
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

        System.out.println("Select language en/de/vi: ");
        String language1 = scan.nextLine();
        ResourceBundle bundle = ResourceBundle.getBundle("ch/noseryoung/blj/language", new Locale(language1));
        String introMessage = bundle.getString("introMessage");
        String firstcoordinateMSG = bundle.getString("firstcoordinateMSG");
        String secondcoordinateMSG = bundle.getString("secondcoordinateMSG");
        String uncoveredwordMSG = bundle.getString("uncoveredwordMSG");
        String solvedMSG = bundle.getString("solvedMSG");
        System.out.println(introMessage);

        while (true) {
            /*System.out.println("\n  +---0---+---1---+---2---+---3---+---4---+---5---+");
            for (int i = 0; i < 6; i++) {
                System.out.print(i);
                for (int a = 0; a < 6; a++) {
                    System.out.print(" | " + uncoveredField[i][a]);
                }
                System.out.println(" | \n");
            }
            System.out.println("  +-------+-------+-------+-------+-------+-------+");*/
            Methods.printField(coveredField);
            boolean passed1 = true;
            int x1 = 0;
            int y1 = 0;
            do {
                System.out.println(firstcoordinateMSG);
                x1 = scan.nextInt();
                y1 = scan.nextInt();
                if (!Methods.coordinateCheck(x1, y1, bundle, language1)){
                    passed1 = false;
                }
                else {
                    passed1 = true;
                }
                for (int i = 0; i < revealedWords.size(); i++) {
                    if (uncoveredField[x1][y1].equals(revealedWords.get(i))) {
                        passed1 = false;
                    }
                    else {
                        passed1 = true;
                    }
                }
                if (!passed1) {
                    System.out.println(uncoveredwordMSG);
                }

            } while (!passed1);
            coveredField[x1][y1] = uncoveredField[x1][y1];
            Methods.printField(coveredField);

            boolean passed2 = true;
            int x2 = 0;
            int y2 = 0;
            do {
                System.out.println(secondcoordinateMSG);
                x2 = scan.nextInt();
                y2 = scan.nextInt();
                if (!Methods.coordinateCheck(x2, y2, bundle, language1)){
                    passed2 = false;
                }
                else {
                    passed2 = true;
                }
                if (x1 == x2 && y1 == y2){
                    passed2 = false;
                }
                for (int i = 0; i < revealedWords.size(); i++) {
                    if (uncoveredField[x2][y2].equals(revealedWords.get(i))) {
                        passed2 = false;
                    }
                    else {
                        passed2 = true;
                    }
                }
                if (!passed2) {
                    System.out.println(uncoveredwordMSG);
                }
            } while (!passed2);

            coveredField[x2][y2] = uncoveredField[x2][y2];
            Methods.printField(coveredField);
            Methods.checkWords(coveredField, uncoveredField, x1, x2, y1, y2, revealedWords, bundle, language1);

            won = false;
            turnCounter++;
            if (turnCounter >= 18 && Arrays.deepEquals(coveredField, uncoveredField)) {
                won = true;
                break;
            }
        }
        if (won){
            System.out.println(solvedMSG);
        }
    }
}