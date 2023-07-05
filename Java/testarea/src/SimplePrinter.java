public class SimplePrinter extends Thread{
    @Override
    public void run(){
        System.out.println("run loop start");
        for (int i = 0; i < 10; i++){
            System.out.println("#");
        }
        System.out.println("run loop end");
    }
}
