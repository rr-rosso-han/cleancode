package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 2/20/15.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        boolean first = true;
        int result = 0;
        for (int i = 0; i < num.length - 1; i++) {
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            int lt = i + 1;
            int gt = num.length - 1;
            int a = num[i];
            while (lt < gt) {
                if (lt > i+1 && num[lt]==num[lt - 1]) {
                    lt++;
                    continue;
                }
                if (gt < num.length - 1 && num[gt] == num[gt + 1]) {
                    gt--;
                    continue;
                }
                int sum = a + num[lt] + num[gt];
                if (first) {
                    result = sum;
                    first = false;
                } else {
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
                if (result == target) return result;
                if (sum > target) {
                    gt--;
                } else {
                    lt++;
                }
            }
        }
        return result;
    }
}
