import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a URL: ");
        String url = scan.nextLine();
        StringBuilder newurl = new StringBuilder();

        for (int i = 0; i < url.length(); i++){
            switch (url.charAt(i)){
                case ' ': newurl.append("%20");
                case '*': newurl.append("%2A");
                case '+': newurl.append("%2B");
                case ',': newurl.append("%2C");
                case '/': newurl.append("%2F");
                case ':': newurl.append("%3A");
                case ';': newurl.append("%3B");
                case '=': newurl.append("%3D");
                case '?': newurl.append("%3F");
                default: newurl.append(url.charAt(i));
            }
        }
        System.out.println("The new URL is: " + newurl);
    }
}