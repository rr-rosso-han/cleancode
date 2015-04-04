package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 1/17/15.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(num);
        int[] visited = new int[num.length];
        permuteUniqueHelper(result, path, num, visited);
        return result;
    }

    private void permuteUniqueHelper(List<List<Integer>> result,
                                     List<Integer> path,
                                     int[] num,
                                     int[] visited) {
        if (path.size() == num.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            path.add(num[i]);
            permuteUniqueHelper(result, path, num, visited);
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }
}
