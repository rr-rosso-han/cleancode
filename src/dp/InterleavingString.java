package dp;

import org.junit.Test;

/**
 * Created by jiahan on 2/16/15.
 */
public class InterleavingString {
    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "bc";
        String s3 = "babc";
        boolean r = isInterleave(s1, s2, s3);
        return;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= len2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for(int l1 = 1; l1 <= len1; l1++) {
            char c1 = s1.charAt(l1 - 1);
            for (int l2 = 1; l2 <= len2; l2++) {
                char c2 = s2.charAt(l2 - 1);
                int l3 = l1 + l2;
                char c3 = s3.charAt(l3 - 1);
                if (c1 == c3) {
                    dp[l1][l2] = dp[l1 - 1][l2] || dp[l1][l2];
                }

                if (c2 == c3) {
                    dp[l1][l2] = dp[l1][l2 - 1] || dp[l1][l2];
                }
            }
        }
        return dp[len1][len2];
    }
}
