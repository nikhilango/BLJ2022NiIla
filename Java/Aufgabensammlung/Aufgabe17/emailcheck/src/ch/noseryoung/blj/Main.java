package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        String email = "nikhil.ilango@gmail.com";
        int i = 0;
        int j = 0;
        int y = 0;
        boolean stage1 = false;
        boolean stage2 = false;
        boolean stage3 = false;

        while (email.charAt(i) == '@'){
            i++;
        }
        if (i >= 1){
            stage1 = true;
        }
        while (email.charAt(j) == '.'){
            j++;
        }
        if (j >= 1){
            stage2 = true;
        }
        while (email.charAt(y) == '.'){
            y++;
        }
        if (y >= 2 && y <= 3){
            stage3 = true;
        }
    }
}
