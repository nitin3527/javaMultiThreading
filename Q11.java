class SynchronizeBlock {
    Thread t = new Thread();
     public void show(int n){
         synchronized(this){
             int count = 0;
             for (int i = 0; i < n; i++) {
                 try {
                     t.sleep(300);
                 } catch (Exception e) {
                     System.out.println(e);
                 }
                 count++;
                 System.out.println("count is: " + count);
             }
         }
     }
}
class CreateThread1 implements Runnable {
    Synchronize s1;
    CreateThread1(Synchronize s1){
        this.s1 = s1;
    }
    @Override
    public void run() {
        s1.show(2);
    }
}
class CreateThread3 implements Runnable {
    Synchronize s1;
    CreateThread3(Synchronize s1){
        this.s1 = s1;
    }
    @Override
    public void run() {
        s1.show(5);
    }
}
public class Q11 {
    public static void main(String[] args) {
        Synchronize sy = new Synchronize();
        CreateThread1 ct = new CreateThread1(sy);
        CreateThread3 ct2 = new CreateThread3(sy);
        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct2);
        t1.start();
        t2.start();
    }
}
