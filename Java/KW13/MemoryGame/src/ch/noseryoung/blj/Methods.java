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
}
