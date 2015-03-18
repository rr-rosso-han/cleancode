package interview.ebates.designpattern.adapter.classadapter;

import interview.ebates.designpattern.adapter.Source;
import interview.ebates.designpattern.adapter.Targetable;

/**
 * Created by jiahan on 2/25/15.
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is targetable method!");
    }
}
