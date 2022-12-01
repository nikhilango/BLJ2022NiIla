package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        int[] numbers= {1, 2, 3, 4, 5, 6};
        int a = 5;
        for (int i = 0; i < 4; i++){
            int temp = numbers[i];
            numbers[i] = numbers[a];
            numbers[a] = temp;
            a--;
        }
        for (int i = 0; i < 6; i++){
            System.out.println(numbers[i]);
        }
    }
}
