package ch.noseryoung.blj;

import java.util.ArrayList;

public class Methods {
    public static String[][] initMemoryWords(ArrayList<String> words, String[][] uncoveredField){
            for (int i = 0; i < 6; i++){
                for (int a = 0; a < 6; a++){
                    uncoveredField[i][a] = words.get(i* 6 + a);
                }
            }
        return uncoveredField;
    }
    public static boolean coordinateCheck(int x, int y){
        if (x > 6 || y > 6){
            System.out.println("The given coordinates don't exist!");
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
}
