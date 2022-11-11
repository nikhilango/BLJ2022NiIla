package ch.noseryoung.blj;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n**********WELCOME TO THE MORSE CODE TRANSLATOR************");
        System.out.println("Select mode (1 = letters to morse code) | (2 = morse code to letters): ");
        int mode = input.nextInt();

        Translator.translate(mode);
    }
}
