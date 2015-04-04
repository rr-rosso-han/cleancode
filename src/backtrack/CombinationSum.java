package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 1/18/15.
 */
public class CombinationSum {

    @Test
    public void combinationSum() {
        int[] a = {1, 2};
        int t = 3;
        List<List<Integer>> r = combinationSum(a, t);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return result;
        }
        combinationSumHelper(result, path, 0, candidates, target, 0);
        return result;

    }

    private void combinationSumHelper(List<List<Integer>> result,
                                      List<Integer> path,
                                      int pathSum,
                                      int[] C,
                                      int T,
                                      int pos) {
        if (pathSum > T) {
            return;
        }

        if (pathSum == T) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i < C.length; i++) {
            pathSum += C[i];
            path.add(C[i]);
            combinationSumHelper(result, path, pathSum, C, T, i);
            path.remove(path.size() - 1);
            pathSum = pathSum - C[i];
        }
    }
}
