package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiahan on 2/23/15.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        ExceptionTest t = new ExceptionTest();
        t.uncheckedException("");
    }
    public void uncheckedException(String str) {
        Map<String, Integer> map = new HashMap<>();
        map.put(str, 1);
        try {
            String s = "2";
            Integer i = map.get(s);
            i.equals(1);
        } catch (NullPointerException ne) {
            System.out.println("test");
            ne.printStackTrace();
        }
    }
}
