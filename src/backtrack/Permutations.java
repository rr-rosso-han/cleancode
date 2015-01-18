package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 1/17/15.
 */
public class Permutations {
    @Test
    public void permute() {
        int[] a = {1};
        List<List<Integer>> b = permute(a);
    }

    public List<List<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(num);
        int n = num.length;
        permuteHelper(result, path, num, n);
        return result;
    }

    private void permuteHelper(List<List<Integer>> result,
                               List<Integer> path,
                               int[] num,
                               int n) {
        if (path.size() == n) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (path.contains(num[i])) continue;
            path.add(num[i]);
            permuteHelper(result, path, num, n);
            path.remove(path.size() - 1);
        }
    }
}
