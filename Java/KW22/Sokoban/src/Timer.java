import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer extends TimerTask {
    private int passedSeconds = 15;
    @Override
    public void run() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Schedule a task to run after an initial delay of 500 milliseconds
        executor.scheduleAtFixedRate(() -> {
            // Add your desired logic here

            System.out.println(passedSeconds + " remaining seconds");
            System.out.println("\n\n\n\n");
            passedSeconds--;
            noTime();
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    public void start(){
        Timer example = new Timer();
        example.run();
    }

    public void noTime(){
        if (passedSeconds == 0){
            System.out.println("YOU LOST!!");
            System.exit(0);
        }
    }
}
