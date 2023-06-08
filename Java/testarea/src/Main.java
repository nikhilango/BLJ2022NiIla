
public class Main {
    private int i = 1;
    public static void main(String[] args) {
        int i = 2;
        Main s = new Main();
        s.someMethod();
    }

    public void someMethod(){
        System.out.println(i);
    }
}
