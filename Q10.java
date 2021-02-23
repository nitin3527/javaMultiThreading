class Synchronize {
    Thread t = new Thread();
    synchronized public void show(int n){
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
class CreateThread implements Runnable {
    Synchronize s1;
    CreateThread(Synchronize s1){
        this.s1 = s1;
    }
    @Override
    public void run() {
        s1.show(2);
    }
}
class CreateThread2 implements Runnable {
    Synchronize s1;
    CreateThread2(Synchronize s1){
        this.s1 = s1;
    }
    @Override
    public void run() {
        s1.show(5);
    }
}
public class Q10 {
    public static void main(String[] args) {
        Synchronize sy = new Synchronize();
        CreateThread ct = new CreateThread(sy);
        CreateThread2 ct2 = new CreateThread2(sy);
        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct2);
        t1.start();
        t2.start();
    }
}
