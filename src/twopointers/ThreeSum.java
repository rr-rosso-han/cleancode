package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 2/20/15.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) break;
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
                if (a + num[lt] + num[gt] == 0) {
                    List<Integer> path = new ArrayList<>();
                    path.add(a);
                    path.add(num[lt]);
                    path.add(num[gt]);
                    result.add(path);
                    gt--;
                    lt++;
                } else if (a + num[lt] + num[gt] > 0) {
                    gt--;
                } else {
                    lt++;
                }
            }

        }
        return result;
    }
}