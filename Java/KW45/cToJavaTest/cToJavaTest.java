import java.util.Scanner;
public class cToJavaTest {
    public static void main(String[] args) {
        System.out.println("-----------------------");
        System.out.println("Average Mark Calculator");
        System.out.println("-----------------------");

        float nums[] = new float[5];
        float result = 0;
        float average;
        float averageDivider = 0;
        float weight[] = new float[5];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            System.out.println("Type a number: ");
            nums[i] = input.nextFloat();
            if(nums[i] < 1 || nums[i] > 6){
                System.out.println("A number from 1 to 6 boi");
                return;
            }
            System.out.println("Enter the weight of the mark decimals: ");
            weight[i] = input.nextFloat();
        }

        System.out.println("-----------------------");

        for(int x = 0; x < 5; x++){
            result = (nums[x] * weight[x]) + result;
        }

        for(int y = 0; y < 5; y++){
            averageDivider = weight[y] + averageDivider;
        }
        average = result / averageDivider; //averageDivider = All the weights added together.
        System.out.println("The average is: " + average);
        System.out.println("Test test test");
    }
}
