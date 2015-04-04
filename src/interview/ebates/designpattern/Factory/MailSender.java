package interview.ebates.designpattern.Factory;

/**
 * Created by jiahan on 2/24/15.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mail sender!");
    }
}
