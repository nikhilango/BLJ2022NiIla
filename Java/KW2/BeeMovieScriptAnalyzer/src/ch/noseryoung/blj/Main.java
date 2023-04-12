package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("WELCOME TO THE TEXT ANALYZER");
        System.out.println("----------------------------");
        System.out.print("Enter a file path: ");
        String path = scan.nextLine();
        System.out.print("Loading");

        for (int i = 0; i < 5; i++){
            try {
                Thread.sleep(500);
                System.out.print(".");
            }
            catch (InterruptedException e){
            }
        }

        Methods.readData(path);
        Methods.calculateMostCommonWord(path);
        System.out.println();
        System.out.println("Please view the generated file for the statistics");
    }
}

//src/ch/noseryoung/blj/script.txt