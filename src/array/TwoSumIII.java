package array;

import misc.IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiahan on 1/6/15.
 */
public class TwoSumIII {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public void add(int input) {
        if (map.containsKey(input)) {
            map.put(input, map.get(input) + 1);
        } else {
            map.put(input, 1);
        }
    }

    public boolean find(int val) {
        if (map.isEmpty()) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int a = entry.getKey();
            int b = val - a;
            if (b == a) {
                if (entry.getValue() >= 2) {
                    return true;
                }
            } else {
                if (map.containsKey(b)) {
                    return true;
                }
            }
        }
        return false;
    }
}
