package backtrack;

import org.junit.Test;

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

    @Test
    public void test() {
        int[] a = {1, 2, 3};
        List<List<Integer>> r = subsets2(a);
        return;
    }
    public List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S == null || S.length == 0) {
            return result;
        }
        Arrays.sort(S);

        int max = 1 << S.length;  // 0 .. 2^n -1
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int key = i;
            for (int j = 0; j < S.length; j++) {
                if ((key & 1) == 1) {
                    list.add(S[j]);
                }
                key >>= 1;
            }
            result.add(list);
        }
        return result;
    }
}
