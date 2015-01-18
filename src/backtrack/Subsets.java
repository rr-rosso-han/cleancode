package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 1/17/15.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(S);
        subsetsHelper(result, path, 0, S);
        return result;
    }

    private void subsetsHelper(List<List<Integer>> result,
                               List<Integer> path,
                               int pos,
                               int[] S) {
        result.add(new ArrayList<Integer>(path));

        for (int i = pos; i < S.length; i++) {
            path.add(S[i]);
            subsetsHelper(result, path, i + 1, S);
            path.remove(path.size() - 1);
        }
    }
}
