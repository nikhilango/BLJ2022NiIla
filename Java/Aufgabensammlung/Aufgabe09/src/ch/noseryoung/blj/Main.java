package ch.noseryoung.blj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int year = 2024;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year: ");
        year = input.nextInt();

        calcLeapYear(year);
    }
    public static void calcLeapYear(int year){

        if (year % 400 == 0) {
            System.out.println("Year "+ year + " is a leap year");
        }

        else if (year % 100 == 0) {
            System.out.println("Year "+ year + " is a leap year");
        }

        else if (year % 4 == 0) {
            System.out.println("Year "+ year + " is a leap year");
        }

        else {
            System.out.println("Year "+ year + " is not a leap year");
        }
    }
}

