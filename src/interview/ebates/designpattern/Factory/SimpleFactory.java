package interview.ebates.designpattern.Factory;

/**
 * Created by jiahan on 2/24/15.
 */

public class SimpleFactory {
    public Sender produce(String name) {
        if ("mail".equals(name)) {
            return new MailSender();
        } else if ("sms".equals(name)) {
            return new SmsSender();
        } else {
            throw new IllegalArgumentException("wrong name");
        }
    }
}
