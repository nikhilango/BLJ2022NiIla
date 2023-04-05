package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Methods {
    public static String[][] initCoveredfield(String[][] coveredField){
        for (int i = 0; i < 6; i++) {
            for (int a = 0; a < 6; a++) {
                coveredField[i][a] = "*****";
            }
        }
        return coveredField;
    }
    public static String[][] initMemoryWords(ArrayList<String> words, String[][] uncoveredField){
            for (int i = 0; i < 6; i++){
                for (int a = 0; a < 6; a++){
                    uncoveredField[i][a] = words.get(i* 6 + a);
                }
            }
        return uncoveredField;
    }
    public static boolean coordinateCheck(int x, int y, ResourceBundle bundle, String language){
        bundle = ResourceBundle.getBundle("ch/noseryoung/blj/language", new Locale(language));
        if (x > 5 || y > 5){
            System.out.println(bundle.getString("nocoordinatesMSG"));
            return false;
        }
        else {
            return true;
        }
    }
    public static void printField(String[][] coveredField){
        System.out.println("\n  +---0---+---1---+---2---+---3---+---4---+---5---+");
        for (int i = 0; i < 6; i++) {
            System.out.print(i);
            for (int a = 0; a < 6; a++) {
                System.out.print(" | " + coveredField[i][a]);
            }
            System.out.println(" | \n");
        }
        System.out.println("  +-------+-------+-------+-------+-------+-------+");
    }
    public static void checkWords(String[][] coveredField, String[][] uncoveredField, int x1, int x2, int y1, int y2, ArrayList revealedWords, ResourceBundle bundle, String language){
        bundle = ResourceBundle.getBundle("ch/noseryoung/blj/language", new Locale(language));
        if (coveredField[x1][y1].equals(uncoveredField[x2][y2])) {
            System.out.println(bundle.getString("foundbothwordsMSG"));
            revealedWords.add(uncoveredField[x2][y2]);
        }
        else {
            System.out.println(bundle.getString("nowordsMSG"));
            coveredField[x1][y1] = "*****";
            coveredField[x2][y2] = "*****";
        }
    }
}
