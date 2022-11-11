package ch.noseryoung.blj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Translator {
    public static void translate(int mode){
        HashMap<String, String> morseCode = new HashMap<String, String>();
        Scanner input = new Scanner(System.in);
        morseCode.put(" ", "/");
        morseCode.put("a", ".-");
        morseCode.put("b", "-...");
        morseCode.put("c", "-.-.");
        morseCode.put("d", "-..");
        morseCode.put("e", ".");
        morseCode.put("f", "..-.");
        morseCode.put("g", "--.");
        morseCode.put("h", "....");
        morseCode.put("i", "..");
        morseCode.put("j", ".---");
        morseCode.put("k", "-.-");
        morseCode.put("l", ".-..");
        morseCode.put("m", "--");
        morseCode.put("n", "-.");
        morseCode.put("o", "---");
        morseCode.put("p", ".--.");
        morseCode.put("q", "--.-");
        morseCode.put("r", ".-.");
        morseCode.put("s", "...");
        morseCode.put("t", "-");
        morseCode.put("u", "..-");
        morseCode.put("v", "...-");
        morseCode.put("w", ".--");
        morseCode.put("x", "-..-");
        morseCode.put("y", "-.--");
        morseCode.put("z", "--..");
        morseCode.put("0", ".----");
        morseCode.put("1", "..---");
        morseCode.put("2", "...--");
        morseCode.put("3", "....-");
        morseCode.put("4", ".....");
        morseCode.put("5", "-....");
        morseCode.put("6", "--...");
        morseCode.put("7", "---..");
        morseCode.put("8", "----.");
        morseCode.put("9", "-----");
        HashMap<String, String> alphabet = new HashMap<String, String>();
        alphabet.put( "/", " ");
        alphabet.put(".-", "a") ;
        alphabet.put("-...", "b");
        alphabet.put( "-.-.", "c");
        alphabet.put( "-..", "d");
        alphabet.put(".", "e");
        alphabet.put("..-.", "f");
        alphabet.put("--.", "g");
        alphabet.put("....", "h");
        alphabet.put( "..", "i");
        alphabet.put(".---", "j");
        alphabet.put("-.-", "k");
        alphabet.put(".-..", "l");
        alphabet.put( "--", "m");
        alphabet.put( "-.", "n");
        alphabet.put( "---", "o");
        alphabet.put( ".--.", "p");
        alphabet.put( "--.-", "q");
        alphabet.put(".-.", "r");
        alphabet.put("...", "s");
        alphabet.put( "-", "t");
        alphabet.put("..-", "u");
        alphabet.put("...-", "v");
        alphabet.put(".--", "w");
        alphabet.put("-..-", "x");
        alphabet.put("-.--", "y");
        alphabet.put( "--..", "z");
        alphabet.put(".----", "0");
        alphabet.put("..---", "1");
        alphabet.put("...--", "2");
        alphabet.put("....-", "3");
        alphabet.put(".....", "4");
        alphabet.put("-....", "5");
        alphabet.put("--...", "6");
        alphabet.put("---..", "7");
        alphabet.put("----.", "8");
        alphabet.put("-----", "9");
        if (mode == 1){
            System.out.println("****************************************************************************");
            System.out.println("Enter a sentece: ");
            String sentence = input.nextLine();
            sentence = sentence.toLowerCase();
            for (int i = 0; i < sentence.length(); i++) {
                char letters = sentence.charAt(i);
                String letter = "" + letters;
                System.out.print(morseCode.get(letter) + " ");
            }
            System.out.println("\n****************************************************************************");
        }
        else if(mode == 2){
            ArrayList<String> conversion = new ArrayList<>();
            while(true){
                System.out.println("****************************************************************************");
                System.out.println("Enter a morse code LETTER BY LETTER (X when you are finished): ");
                String morse = input.nextLine();
                if (morse.equals("X")){
                    for (int i = 0; i < conversion.size(); i++){
                    System.out.print(alphabet.get(conversion.get(i)));
                    }
                    System.out.println("\n****************************************************************************");
                    return;
                }
                conversion.add(morse);
            }
        }
    }
}
