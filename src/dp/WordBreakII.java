package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jiahan on 2/13/15.
 */
public class WordBreakII {


    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        List<String> path = new ArrayList<>();
        dfs(result, path, s, dict, 0, dp);
        return result;
    }

    private void dfs(List<String> result,
                     List<String> path,
                     String s, Set<String> dict,
                     int pos,
                     boolean[] dp) {
        if (pos == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str: path) {
                sb.append(str);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        if (!dp[pos]) {
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String left = s.substring(pos, i + 1);
            if (!dict.contains(left)) {
                continue;
            }
            path.add(left);
            dfs(result, path, s, dict, i + 1, dp);
            path.remove(path.size() - 1);
        }
    }
}
