package interview.ebates.designpattern.adapter.classadapter;

import interview.ebates.designpattern.adapter.Targetable;

/**
 * Created by jiahan on 2/25/15.
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
