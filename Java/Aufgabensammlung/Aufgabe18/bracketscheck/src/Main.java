import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkBrackets("{(xxx,yyy)}"));
        System.out.println(checkBrackets("{)(acd,bcvfs}"));
        System.out.println(checkBrackets("{(xxx},yyy)"));
        System.out.println(checkBrackets("[(xxx),yyy]"));
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