package interview.ebates.thread;

/**
 * Created by jiahan on 2/24/15.
 */
public class RunnableTest {
    public static void main(String[] args) {
        Runnable1 r = new Runnable1();
        Thread t1 = new Thread(r);
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:"+i);
        }
    }
}

class Runnable1 implements Runnable {
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 1; i <= 5; i++) {
            System.out.println("实现Runnable接口的线程----->"+i);
        }
    }
}
