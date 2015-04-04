package bitmanipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public int singleNumberOnePass(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            } else {
                set.add(A[i]);
            }
        }
        if (set.size() != 1) {
            throw new IllegalArgumentException("No single Number");
        }

        return set.iterator().next();
    }

    public int singleNumberXOR(int[] A) {
        int num = 0;
        for (int x : A) {
            num ^= x;
        }
        return num;
    }
}
