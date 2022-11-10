package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++){
           String num = String.format("%04d", i);
            System.out.println(num);
        }
    }
}
