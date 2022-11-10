package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        int num = 12;
        int divisor = 1;

        while (num / divisor >= 10){
            divisor *= 10;
        }

        while (num != 0) {
            int firstdig = num / divisor;
            int lastdig = num % 10;

            if (firstdig != lastdig){
                System.out.println(num + " is not a palindrome.");
                break;
            }
            else {
                System.out.println(num + " is a palindrome.");
                break;
            }
        }
    }
}
