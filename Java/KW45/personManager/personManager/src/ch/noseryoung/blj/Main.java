package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstname[] = new String[5];
        String lastname[] = new String[5];
        String genders[] = new String[5];
        String favfood[] = new String[5];
        String emails[] = new String[5];

        for (int i = 0; i < 5; i++){
            System.out.printf("Enter " + (i  + 1) +". Person's First name: ");
            firstname[i] = input.nextLine();
            System.out.printf("Enter " + (i  + 1) +". Person's Last name: ");
            lastname[i] = input.nextLine();
            System.out.printf("Enter " + (i  + 1) +". Persons gender: ");
            genders[i] = input.nextLine();
            System.out.printf("Enter the person's favourite food: ");
            favfood[i] = input.nextLine();
            System.out.printf("Enter the person's email address: ");
            emails[i] = input.nextLine();
            System.out.println("*************************************************************");
        }
        System.out.println("Data has been successfully saved.");
        System.out.printf("Loading data: ");

        for (int i = 0; i < 8; i++){
            try{
                System.out.printf("■");
                Thread.sleep(300);
            }
            catch (InterruptedException e){
                System.out.println("ERROR");
            }
        }
        System.out.println("\n");
        for (int i = 0; i < 5; i++){
            Person Persons = new Person(firstname[i],lastname[i], genders[i], favfood[i], emails[i]);
            Persons.presentYourself();
        }
    }
}
