package dp;

import org.junit.Test;

/**
 * Created by jiahan on 2/16/15.
 */
public class LongestValidParentheses {
    @Test
    public void test() {
        String s = "(((()(()";
        int a = longestValidParentheses(s);
        return;
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length(), maxLen = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int j = i - 2 - dp[i - 1];
            if(s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 2 + dp[j];
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
