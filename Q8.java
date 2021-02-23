import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Scheduling implements Runnable{
    Thread t = new Thread();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                t.sleep(300);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(t.getName());
        }
    }
}
public class Q8 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        LocalDateTime now = LocalDateTime.now();
        Future result1 = executor.schedule(new Scheduling(), Duration.between(now, now.plusSeconds(2)).toMillis(),
                TimeUnit.MILLISECONDS);
        Future result2 = executor.scheduleAtFixedRate(new Scheduling(),2,1,TimeUnit.MILLISECONDS );
        Future result3 = executor.scheduleAtFixedRate(new Scheduling(),1,3,TimeUnit.MILLISECONDS );
        System.out.println(result1.isDone());
        System.out.println(result3.isDone());
        System.out.println(result3.isDone());
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        System.out.println(result1.isDone());
        System.out.println(result2.isDone());
        System.out.println(result3.isDone());
    }
}
