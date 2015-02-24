package interview.ebates;

/**
 * Created by jiahan on 2/24/15.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t = new Thread1();
        //t.run(); //这里也不能直接调用方法
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:"+i);
        }
    }
}

class Thread1 extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread-----:"+i);
        }
    }
}
