package DivideandConquer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiahan on 2/9/15.
 */
public class MajorityElement {

    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException("input cannot be null");
        }
        int len = num.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);
            }
            if (map.get(num[i]) > len / 2) {
                return num[i];
            }
        }

        throw new IllegalArgumentException("input not valid");
    }

    public int majorityElementII(int[] num) {
        int candidate = num[0];
        int count = 1;

        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                candidate = num[i];
                count = 1;
            } else {
                if (candidate == num[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    public int majorityElementIII(int[] num) {
        return majorityElementHelper(num, 0, num.length - 1);
    }

    private int majorityElementHelper(int[] num, int start, int end) {
        if (start == end) {
            return num[start];
        }
        int mid = start + (end - start) / 2;
        int A = majorityElementHelper(num, start, mid);
        int B = majorityElementHelper(num, mid + 1, end);

        int countA = 0;
        int countB = 0;
        if (A == B) {
            return A;
        } else {
            for (int i = start; i <= end; i++) {
                if (num[i] == A) {
                    countA++;
                } else if (num[i] == B) {
                    countB++;
                }
            }
            return countA > countB ? A : B;
        }
    }
}
