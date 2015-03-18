package interview.ebates.thread;

/**
 * Created by jiahan on 2/24/15.
 */
public class JoinDemo {
    public static void main(String[] args) {
        T1 t1=new T1("T1");
        T2 t2=new T2("T2");
        T3 t3=new T3("T3");
        t1.start();
        try {
            t1.join();//wait until t1 is done
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();//wait until t2 is done
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t3.start();
    }
}

class T1 extends  Thread{
    private String name;
    public T1(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try {
                sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(this.name+"循环"+i);
        }
    }
}
class T2 extends  Thread{
    private String name;
    public T2(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try {
                sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(this.name+"循环"+i);
        }
    }
}
class T3 extends  Thread{
    private String name;
    public T3(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(this.name+"循环"+i);
        }
    }
}
