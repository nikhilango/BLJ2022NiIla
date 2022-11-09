package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        int height = 7;
        int spaces = height-1;
        int calc;
        for(int i = 0; i < height; i++) {
            calc = (2 * i) + 1;
            for(int j = 1; j <= spaces + calc; j++) {
                if(j <= spaces){
                    System.out.print(' ');
                }
                else{
                    System.out.print('*');
                }
            }
            System.out.println();
            spaces--;
        }
        System.out.println("       ***");
    }
}
