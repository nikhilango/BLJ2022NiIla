import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a bracket order: ");
        String order = scan.nextLine();

        System.out.println("The bracket order is closed: " + checkBrackets(order));
    }
    public static boolean checkBrackets(String order) {
        Stack<Character> object  = new Stack<>();
        for(int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if(ch == '[' || ch == '(' || ch == '{' ) {
                object.push(ch);
            }
            else if(ch == ']') {
                if(object.isEmpty() || object.pop() != '[') {
                    return false;
                }
            }
            else if(ch == ')') {
                if(object.isEmpty() || object.pop() != '(') {
                    return false;
                }
            }
            else if(ch == '}') {
                if(object.isEmpty() || object.pop() != '{') {
                    return false;
                }
            }
        }
        return object.isEmpty();
    }
}