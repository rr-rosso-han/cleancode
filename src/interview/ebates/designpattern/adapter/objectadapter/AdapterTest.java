package interview.ebates.designpattern.adapter.objectadapter;

import interview.ebates.designpattern.adapter.Source;
import interview.ebates.designpattern.adapter.Targetable;

/**
 * Created by jiahan on 2/25/15.
 */
public class AdapterTest {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
