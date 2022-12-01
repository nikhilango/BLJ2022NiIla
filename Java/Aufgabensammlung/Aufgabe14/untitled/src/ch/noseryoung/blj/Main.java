package ch.noseryoung.blj;

public class Main {
    public static void main(String[] args) {
        int numbers[] = new int[] { 1, 5, 3, 19, 29, 25 };
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length - 1; i++){
            for (int j = i + 1; j < numbers.length; j++){
                if (Math.abs((numbers[i] - numbers[j])) < diff){
                    diff = Math.abs((numbers[i] - numbers[j]));
                }
            }
        }
        System.out.println("Minimum difference is " + diff);
    }
}
