package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 1/17/15.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(num);
        subsetsWithDupHelper(result, path, 0, num);
        return result;
    }
    private void subsetsWithDupHelper(List<List<Integer>> result,
                                      List<Integer> path,
                                      int pos,
                                      int[] num) {
        result.add(new ArrayList<Integer>(path));
        for (int i = pos; i < num.length; i++) {
            if (i > 0 && i != pos && num[i] == num[i - 1]) {
                continue;
            }
            path.add(num[i]);
            subsetsWithDupHelper(result, path, i + 1, num);
            path.remove(path.size() - 1);
        }
        return;
    }
}
