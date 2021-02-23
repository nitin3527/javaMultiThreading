import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FutureObj implements Runnable{
    Thread t = new Thread();
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            try{
                t.sleep(300);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(t.getName());
        }
    }
}
public class Q6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureObj fobj = new FutureObj();
        Future<String> obj = executor.submit(fobj,"Executing thread");
        executor.shutdown();
        System.out.println("get is: "+ obj.get());
        System.out.println("isDone: " + obj.isDone());
        System.out.println("isCancelled: " + obj.isCancelled());

    }
}
