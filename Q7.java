import java.util.concurrent.*;

class AwaitTermination implements Runnable {
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
public class Q7 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future result1 = executor.submit(new AwaitTermination());
        Future result2 = executor.submit(new AwaitTermination());
        executor.shutdown();
        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-2 is done : " + result2.isDone());
        executor.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("Task-1 is done : " + result1.isDone());
        System.out.println("Task-2 is done : " + result2.isDone());
    }
}
