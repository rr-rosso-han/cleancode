package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 1/19/15.
 */
public class CombinationSumII {
    @Test
    public void combinationSum2() {
        int[] a = {1, 2};
        int t = 4;
        List<List<Integer>> r = combinationSum2(a, t);
    }

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(num);
        if (num[0] > target) {
            return result;
        }
        combinationSum2Helper(result, path, num, target, 0, 0);
        return result;
    }

    private void combinationSum2Helper(List<List<Integer>> result,
                                       List<Integer> path,
                                       int[] C,
                                       int T,
                                       int pos,
                                       int pathSum) {
        if (pathSum > T) {
            return;
        }

        if (pathSum == T) {
            if (!result.contains(path)) {
                result.add(new ArrayList<Integer>(path));
                return;
            }
        }

        for (int i = pos; i < C.length; i++) {
            pathSum += C[i];
            path.add(C[i]);
            combinationSum2Helper(result, path, C, T, i + 1, pathSum);
            path.remove(path.size() - 1);
            pathSum = pathSum - C[i];
        }
    }
}
