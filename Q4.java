import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ShutDown implements Runnable{
    Thread t = new Thread();
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println(t.getName());
        }
    }
}
class ShutDownNow implements Runnable{
    Thread t = new Thread();
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println(t.getName());
        }
    }
}
public class Q4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        ShutDown r1 = new ShutDown();
        ShutDown r2 = new ShutDown();
        executor.submit(r1);
        executor.submit(r2);
        executor.shutdown();
        ShutDownNow r3 = new ShutDownNow();
        ShutDownNow r4 = new ShutDownNow();
        executor2.submit(r3);
        executor2.submit(r4);
        executor2.shutdownNow();
    }
}
