package ch.noseryoung.blj;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount of rows: ");
        int rows = input.nextInt();

        createArena(rows);
    }
    public static void createArena(int rows){
        String arena[][] = new String[rows][rows + 1];
        Random randomGen = new Random();

        int counter = rows + 1;
        for (int i = 0; i < rows; i++ ){
            for (int j = 0; j < counter; j++){
                int randomNum = randomGen.nextInt((1 - 0) + 1) + 0;
                if (randomNum == 1){
                    arena[i][j] = " ■ ";
                }
                 else {
                    arena[i][j] = " ▢";
                }

            }
            counter--;
        }
        for (int i = 0; i < rows; i++ ){
            for (int j = 0; j < (rows + 1); j++){
                if (arena[i][j] == null){
                    arena[i][j] = " ";
                }
                System.out.print(arena[i][j]);
            }
            System.out.println();
        }
    }
}
