package ch.noseryoung.blj;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select mode: (1 = letters to morsecode), (2 = morsecode to letters) ");
        int mode = input.nextInt();

        Translator.translate(mode);
    }
}
