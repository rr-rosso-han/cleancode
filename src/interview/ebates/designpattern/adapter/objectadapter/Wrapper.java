package interview.ebates.designpattern.adapter.objectadapter;

import interview.ebates.designpattern.adapter.Source;
import interview.ebates.designpattern.adapter.Targetable;

/**
 * Created by jiahan on 2/25/15.
 */
public class Wrapper implements Targetable {
    private Source source;
    public Wrapper(Source source) {
        super();
        this.source = source;
    }
    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
