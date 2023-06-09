import java.text.DecimalFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer extends TimerTask {
    private double passedSeconds = 0;
    @Override
    public void run() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            DecimalFormat df = new DecimalFormat("#.#");
            System.out.println(df.format(passedSeconds) + " seconds passed");
            System.out.println("\n\n\n\n\n");
            passedSeconds += 0.1;
            noTime();
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    public void start(){
        Timer example = new Timer();
        example.run();
    }

    public void noTime(){
        if (passedSeconds == 10000){
            System.out.println("YOU LOST!!");
            System.exit(0);
        }
    }
}
