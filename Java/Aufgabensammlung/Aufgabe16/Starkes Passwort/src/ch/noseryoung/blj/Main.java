package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
    String password = "eVJo2!8IrRo";
        isStrong(password);
    }
    public static void isStrong(String password){

        char ch;

        boolean has8Dig = false;
        boolean hasNum = false;
        boolean hasCapital = false;
        boolean hasLow = false;
        boolean hasSpecCh = false;

        if (password.length() >= 8){
            System.out.println("    -Your password has atleast 8 characters");
            has8Dig = true;
        }

        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                System.out.println("    -Your password includes a number");
                hasNum = true;
                break;
            }
        }

        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                System.out.println("    -Your password includes an uppercase letter");
                hasCapital = true;
                break;
            }
        }

        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                System.out.println("    -Your password includes a lowercase letter");
                hasLow = true;
                break;
            }
        }

        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if (ch == '!' || ch == '*') {
                System.out.println("    -Your password includes a special character");
                hasSpecCh = true;
                break;
            }
        }

        if (hasSpecCh && has8Dig && hasNum && hasCapital && hasLow){
            System.out.println("You password is strong!");
        }
        else {
            System.out.println("Your password is not strong!");
        }
    }
}
