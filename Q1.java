class ThreadClass extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is being executed  using thread class");
    }
}
class UsingRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is being executed  using runnable interface");
    }
}
public class Q1 {
    public static void main(String[] args) {
        ThreadClass th = new ThreadClass();
        UsingRunnable inter = new UsingRunnable();
        Thread t1 = new Thread(inter);
        th.start();
        t1.start();
    }
}
