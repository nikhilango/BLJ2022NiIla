package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a day: ");
        int day = input.nextInt();
        System.out.println("Enter a month: ");
        int month = input.nextInt();
        System.out.println("Enter a year: ");
        int year = input.nextInt();

        calcWeekday(day, month, year);
    }
    public static void calcWeekday(int day, int month, int year) {
        int calc = ((year%100)/4) + (year%100);

        switch (month) {
            case 1, 10 -> calc += 1;
            case 5 -> calc += 2;
            case 8 -> calc += 3;
            case 2, 3, 11 -> calc += 4;
            case 6 -> calc += 5;
            case 9, 12 -> calc += 6;
        }
        calc += day;
        switch (year / 100) {
            case 18 -> calc += 2;
            case 20 -> calc += 6;
            case 21 -> calc += 4;
        }
        calc = calcLeapYear(year, calc);
        calc = calc % 7;
        switch (calc) {
            case 0 -> System.out.println("The weekday is saturday");
            case 1 -> System.out.println("The weekday is sunday");
            case 2 -> System.out.println("The weekday is monday");
            case 3 -> System.out.println("The weekday is tuesday");
            case 4 -> System.out.println("The weekday is wednesday");
            case 5 -> System.out.println("The weekday is thursday");
            case 6 -> System.out.println("The weekday is friday");
            default -> System.out.println("Calculation failed!");
        }
    }

    public static int calcLeapYear(int year, int calc){
        if (year % 400 == 0) {
            calc = calc - 1;
        }

        else if (year % 100 == 0) {
            calc = calc - 1;
        }

        else if (year % 4 == 0) {
            calc = calc - 1;
        }
        return calc;
    }
}
