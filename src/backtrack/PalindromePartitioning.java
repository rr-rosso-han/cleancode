package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 1/19/15.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        List<String> path = new ArrayList<>();
        partitionHelper(result, path, s, n, 0);
        return result;
    }

    private void partitionHelper(List<List<String>> result,
                                 List<String> path,
                                 String s,
                                 int n,
                                 int pos) {
        if (pos == n) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos; i < n; i++) {
            String tmp = s.substring(pos, i + 1);
            if (isPalin(tmp)) {
                path.add(tmp);
                partitionHelper(result, path, s, n, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalin(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
