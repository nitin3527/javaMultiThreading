import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Concurrency implements Runnable{
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
public class Q9 {
    public static void main(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
        ThreadPoolExecutor pool2 = (ThreadPoolExecutor) executor2;
        pool.getMaximumPoolSize();
        executor.submit(new Concurrency());
        executor.submit(new Concurrency());

        System.out.println("executor size:" + pool.getMaximumPoolSize());
        System.out.println("executor2 size: " + pool2.getMaximumPoolSize());
        executor2.submit(new Concurrency());
        executor2.submit(new Concurrency());
        executor2.submit(new Concurrency());
        executor.shutdown();
        executor2.shutdown();

    }
}
