package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the hour: ");
        int hour = input.nextInt();
        System.out.printf("Enter the minute: ");
        int min = input.nextInt();

        computeHourHandAngle(hour, min);
        computeMinuteHandAngle(min);
    }

    public static void computeHourHandAngle(int hour, int min){
        int angle = (60 * hour + min)/2;
        System.out.println("Hour hand is at " + angle + " degrees");
    }

    public static void computeMinuteHandAngle(int min){
        int angle = min * 6;
        System.out.println("Minute hand is at " + angle + " degrees");
    }
}
