package ch.noseryoung.blj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Aquarium standard = new Aquarium(1, 4);
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> fishtypes = new ArrayList<Integer>();
        ArrayList<Integer> xpos = new ArrayList<Integer>();
        ArrayList<Integer> ypos = new ArrayList<Integer>();
        int amountOfFish = standard.generateFish();
        int tanksize = standard.getAquariumSize();
        int watertype = standard.generateWatertype();
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        String fishname = null;
        int fishtype;
        int xcounter = 1;
        int ycounter = 1;

        System.out.println("*******************THE AQUARIUM*******************");
        System.out.println("Select fishes from the list below or create you own");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Nemo                                       Fish Type:   Saltwater");
        System.out.println("Dory                                        Fish Type: Sweetwater");
        System.out.println("Gill                                          Fish Type:    Saltwater");
        System.out.println("Peach                                       Fish Type:    Saltwater");
        System.out.println("Bubbles                                   Fish Type: Sweetwater");
        System.out.println("Gurgle                                     Fish Type: Sweetwater");
        System.out.println("Deb                                         Fish Type:     Saltwater");
        System.out.println("Jaques                                    Fish Type:     Saltwater");
        System.out.println("Nigel                                       Fish Type: Sweetwater");
        System.out.println("Crush                                      Fish Type:     Saltwater");
        System.out.println("Coral                                       Fish Type: Sweetwater");
        System.out.println("Anchor                                    Fish Type: Sweetwater");
        System.out.println("Squirt                                     Fish Type:    Saltwater");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                            The water type is " + watertype);
        for (int i = amountOfFish; i > 0; i--){
                System.out.print("Enter a fish name: ");
                fishname = input.nextLine();
                names.add(fishname);
                System.out.print("Enter fish type (Saltwater: 1/Sweetwater: 0): ");
                fishtype = input2.nextInt();
                fishtypes.add(fishtype);
                if (fishtype == 0 || fishtype == 1) {
                    if (fishtype == watertype) {
                        System.out.println(" ");
                    } else {
                        System.out.println("The fish type does not mach the water type!");
                        i++;
                    }
                } else {
                    System.out.println("The fish type does not exist!");
                    i++;
                }
                Fish fish = new Fish(fishname, fishtype);
                fish.presentYouself();
                System.out.println((i - 1) + " fishes left.");
                xpos.add(xcounter);
                ypos.add(ycounter);
                xcounter++;
                if (xcounter == tanksize){
                    ycounter++;
                    ypos.add(ycounter);
                    xcounter = 0;
                }
        }

        String[][] tank = new String[tanksize][tanksize];
        for (int i = 0; i < tanksize; i++){
            for (int j = 0; j < tanksize; j++){
                if (amountOfFish >= 1){
                    tank[i][j] = "\uD83D\uDC1F";
                }
                else {
                    tank[i][j] = " ▢ ";
                }
                amountOfFish--;
            }
        }

        for (int i = 0; i < tanksize; i++){
            for (int j = 0; j < tanksize; j++){
                System.out.print(tank[i][j]);
            }
            System.out.println();
        }

        System.out.println("*************************AQUARIUM DATA*************************");
        for (int i = 0; i < names.size(); i++){
            System.out.println("    -" + names.get(i) + " is a type: " + fishtypes.get(i) + " is at the x-position " + xpos.get(i) + " and at the y-position " + ypos.get(i));
        }
        System.out.println("***************************MOVE FISH*****************************");
        System.out.print("Do you want to move your fishes? 1/0: ");
        int mode = input.nextInt();
        if (mode == 1){
            System.out.print("Select a fish: ");
            String changeFish = input1.nextLine();
            System.out.print("Move to x-position: ");
            int changex = input2.nextInt();
            System.out.print("Move to y-position: ");
            int changey = input3.nextInt();
            if (tank[changey - 1][changex - 1].equals(" ▢ ")){
                int i;
                tank[changey - 1][changex - 1] = "\uD83D\uDC1F";
                 for (i = 0; i < names.size(); i++){
                     if (names.get(i).equals(changeFish)){
                         System.out.println("The fish was found");
                         break;
                     }
                 }
                 tank[ypos.get(i) - 1][xpos.get(i) - 1] = " ▢ ";
            }
            for (int i = 0; i < tanksize; i++){
                for (int j = 0; j < tanksize; j++){
                    System.out.print(tank[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println("****************************KILL A FISH******************************");
        System.out.print("Do you want to kill one of your fishes? 1/0: ");
        int mode3 = input.nextInt();
        if (mode3 == 1){
            System.out.print("Select a fish: ");
            String killFish = input1.nextLine();
                int a = 0;
                while (a < names.size()){
                    if (names.get(a).equals(killFish)){
                        System.out.println("The fish was found!");
                        break;
                    }
                }
                tank[ypos.get(a) - 1][xpos.get(a) - 1] = " ▢ ";

            for (int i = 0; i < tanksize; i++){
                for (int j = 0; j < tanksize; j++){
                    System.out.print(tank[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println("*****************************DECORATE*******************************");
        System.out.print("Do you want to add decorations? 1/0: ");
        int mode2 = input.nextInt();
        if (mode2 == 1){
            System.out.println("Select a x-position: ");
            int decx = input.nextInt();
            System.out.println("Select a y-position: ");
            int decy = input1.nextInt();
            System.out.println("What do you want to add to you aquarium? (1: rock/ 2: shell) : ");
            int decoration = input2.nextInt();
            switch (decoration){
                case 1:
                    tank[decy - 1][decx - 1] = "\uD83E\uDEA8";
                    break;
                case 2:
                    tank[decy - 1][decx - 1] = "\uD83D\uDC1A";
                    break;
            }
            for (int i = 0; i < tanksize; i++){
                for (int j = 0; j < tanksize; j++){
                    System.out.print(tank[i][j]);
                }
                System.out.println();
            }
        }
    }
}
