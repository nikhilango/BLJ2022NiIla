package ch.noseryoung.blj;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> backpack = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String packing;
        int backpackspace = 0;
        while (true){
            System.out.println("******************************************************");
            System.out.print("I packed my bag and in it I put (0 to exit): ");
            packing = input.nextLine();

            if (packing.equals("0")){
                System.out.println("Thank you for playing!");
                break;
            }

            for (int i = 0; i < backpackspace; i++){
                if (backpack.get(i).equals(packing)){
                    backpack.remove(i);
                    backpackspace--;
                    break;
                }
            }

            backpackspace++;
            backpack.add(packing);
            System.out.println("I take: ");
            for (int i = 0; i < backpackspace; i++){
                System.out.println("            -" + backpack.get(i));
            }
        }
    }
}
