import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a bracket order: ");
        String bracketorder = scan.nextLine();
        checkBrackets(bracketorder);
    }
    public static String checkBrackets(String str) {
        Stack<Character> object  = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '[' || ch == '(' || ch == '{' ) {
                object.push(ch);
            } else if(ch == ']') {
                if(object.isEmpty() || object.pop() != '[') {
                    return "The brackets don't close";
                }
            } else if(ch == ')') {
                if(object.isEmpty() || object.pop() != '(') {
                    return "The brackets don't close";
                }
            } else if(ch == '}') {
                if(object.isEmpty() || object.pop() != '{') {
                    return "The brackets don't close";
                }
            }
        }
        return "The brackets close";
    }
}