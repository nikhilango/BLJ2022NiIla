package ch.noseryoung;

public class Timer extends Thread{
    private QuizManager manager;
    public Timer(QuizManager manager){
        this.manager = manager;
    }
    @Override
    public void run(){
        System.out.println("it started");
        try {
            Thread.sleep(3000);
            manager.showQuestion2();
            System.out.println("question 2 displayed");
            Thread.sleep(3000);
            manager.showQuestion3();
            System.out.println("question 3 displayed");
            Thread.sleep(3000);
            manager.showResult();
            System.out.println("it has stopped");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
