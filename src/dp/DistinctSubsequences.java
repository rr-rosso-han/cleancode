package dp;

/**
 * Created by jiahan on 2/15/15.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return 0;
        }
        if (S.length() < T.length()) {
            return 0;
        }
        int lenS = S.length();
        int lenT = T.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= lenS; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= lenS; i++ ) {
            for (int j = i; j <= lenT; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lenS][lenT];
    }
}
