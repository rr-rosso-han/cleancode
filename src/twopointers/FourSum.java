package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 2/20/15.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length - 1; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int lt = j + 1;
                int gt = num.length - 1;
                while (lt < gt) {
                    if (lt > j + 1 && num[lt] == num[lt - 1]) {
                        lt++;
                        continue;
                    }
                    if (gt < num.length - 1 && num[gt] == num[gt + 1]) {
                        gt--;
                        continue;
                    }
                    int sum = num[i] + num[j] + num[lt] + num[gt];
                    if (sum == target) {
                        List<Integer> path = new ArrayList<>();
                        path.add(num[i]);
                        path.add(num[j]);
                        path.add(num[lt]);
                        path.add(num[gt]);
                        result.add(path);
                        gt--;
                        lt++;
                    } else if (sum > target) {
                        gt--;
                    } else {
                        lt++;
                    }
                }
            }
        }
        return result;
    }
}
