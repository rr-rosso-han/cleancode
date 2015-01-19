package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 1/18/15.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 && k > n) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combineHelper(result, path, n, k, 1);
        return result;
    }

    private void combineHelper(List<List<Integer>> result,
                               List<Integer> path,
                               int n,
                               int k,
                               int pos) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = pos; i <= n; i++) {
            path.add(i);
            combineHelper(result, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
