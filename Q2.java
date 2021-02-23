class JoinAndSleep implements Runnable{

    @Override
    public void run() {
        Thread t1 = Thread.currentThread();
        for(int i=0;i<5;i++){
            System.out.println("current thread is: " + t1.getName());
        }
    }
}
public class Q2 {
    public static void main(String[] args) {
        JoinAndSleep t1  = new JoinAndSleep();
        JoinAndSleep t2 = new JoinAndSleep();
        JoinAndSleep t3 = new JoinAndSleep();
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        th1.start();
        th2.start();
        th3.start();
        try{
            th1.sleep(1000);
        }
        catch (Exception e){
            System.out.println(e);
        }
        try{
            th3.join();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
