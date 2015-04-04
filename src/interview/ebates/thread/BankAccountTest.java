package interview.ebates.thread;

/**
 * Created by jiahan on 2/24/15.
 */
public class BankAccountTest {
    public static void main(String[] args){
        saveMoney t1 = new saveMoney();
        t1.start();
        withdrawMoney t2 = new withdrawMoney();
        t2.start();
    }
}

class saveMoney extends Thread {
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            Account.add();
            try {
                sleep(10);//模拟银行系统处理时间
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class withdrawMoney extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            Account.remove();
            try {
                sleep(10);//模拟银行系统处理时间
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Account {
    public static int count = 1000;
    //减去100元
    public static synchronized void remove(){
        count -= 100;
        System.out.println("减去100元,卡内余额"+count);
    }
    //增加100元
    public static synchronized void add(){
        count += 100;
        System.out.println("加上100元,卡内余额"+count);
    }
}
