package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int bodyweight  = 0;
        int height  = 0;
        int age  = 0;
        Scanner input = new Scanner(System.in);
        System.out.printf("Bodyweight: ");
        bodyweight = input.nextInt();
        System.out.printf("Height: ");
        height = input.nextInt();
        System.out.printf("Age: ");
        age = input.nextInt();

        double calorieMale = 66.47 + 13.7 * bodyweight + 5 * height - 6.8 * age;
        double calorieFemale = 655.1+9.6 * bodyweight + 1.8 * height - 4.7 * age;
        System.out.println("Male: " + calorieMale + " calories per day");
        System.out.println("Female: " + calorieFemale + " calories per day");
    }
}
