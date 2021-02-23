import java.util.Scanner;

class RunFunctions {
    public void waitFunc() throws InterruptedException{
        synchronized (this){
            System.out.println("wait func is running");
            wait();
            System.out.println("func running again");
        }
    }
    public void notifyFunc() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("waiting for key");
            sc.nextLine();
            System.out.println("notifying thread");
            notify();
        }
    }

}
public class Q13 {
    public static void main(String[] args)throws InterruptedException {
        RunFunctions rd = new RunFunctions();
        Thread t1 = new Thread(new RunThread(){

            @Override
            public void run(){
               try{
                   rd.waitFunc();
               }catch (InterruptedException e){
                    System.out.println(e);
               }
           }
        });

        Thread t2 = new Thread(new RunThread(){

            @Override
            public void run(){
                try{
                    rd.notifyFunc();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
