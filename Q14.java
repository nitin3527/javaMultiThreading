import java.util.Scanner;

class RunFunction {
    public void waitFunc() throws InterruptedException{
        synchronized (this){
            System.out.println("wait func is running");
            wait();
            System.out.println("func running again");
        }
    }
    public void notifyAllFunc() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("waiting for key");
            sc.nextLine();
            System.out.println("notifying all threads");
            notifyAll();
        }
    }

}
public class Q14 {
    public static void main(String[] args) {
        RunFunction rd = new RunFunction();
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
                    rd.notifyAllFunc();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
