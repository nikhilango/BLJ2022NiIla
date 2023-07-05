
public class Main {
    public static void main(String[] args) {
        new SimplePrinter().start();
        System.out.println("main loop start");
        for (int i = 0; i < 10; i++){
            System.out.println(":");
        }
        System.out.println("main loop end");
    }
}

