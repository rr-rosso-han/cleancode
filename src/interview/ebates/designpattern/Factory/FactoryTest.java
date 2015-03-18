package interview.ebates.designpattern.Factory;

/**
 * Created by jiahan on 2/24/15.
 */
public class FactoryTest {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Sender sender = factory.produce("sms");
        sender.send();
    }
}
