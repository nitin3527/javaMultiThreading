import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class IsTerminated implements Runnable {
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
public class Q5 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        IsTerminated ist = new IsTerminated();
        executor.submit(ist);
        System.out.println(" Is Executor is Shutdown :"+ executor.isShutdown());
        executor.shutdown();
        System.out.println(" Is Executor is Terminated :"+ executor.isTerminated());
    }
}
