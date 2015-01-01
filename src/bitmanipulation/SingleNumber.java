package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiahan on 1/1/15.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length - 1; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            }
            map.put(A[i], 1);
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (map.get(A[i]) == 1) {
                return A[i];
            }
        }
        throw new IllegalArgumentException("Invalid Input");
    }
}
