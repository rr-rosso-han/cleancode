package dp;

import org.junit.Test;

/**
 * Created by jiahan on 2/19/15.
 */
public class RegularExpressionMatching {

    @Test
    public void test() {
        String s = "aab";
        String p = "c*a*b";
        boolean r = isMatch(s, p);
        return;
    }
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int lenS = s.length();
        int lenP = p.length();

        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        for (int i = 0; i <= lenS; i++) {
            char preChar = ' ';
            int preIdx = 0;
            for (int j = 1; j <= lenP; j++) {
                if (i >= 1 && (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (i >= 1 && (preChar == s.charAt(i - 1) || preChar == '.')) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                    dp[i][j] = dp[i][j] || dp[i][preIdx];
                } else {
                    dp[i][j] = i >= 1
                            && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && dp[i - 1][j - 1];
                }
                if(p.charAt(j - 1) != '*') {
                    preChar = p.charAt(j - 1);
                    preIdx = j - 1;
                }
            }
        }
        return dp[lenS][lenP];
    }

    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int lenS = s.length();
        int lenP = p.length();
        if (lenP == 0) {
            return lenS == 0;
        }
        if (lenP == 1) {
            if (p.equals(s) || p.equals(".") && s.length() == 1) {
                return true;
            } else {
                return false;
            }
        }

        if (p.charAt(1) != '*') {
            if (s.length() == 0 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        } else {
            while (s.length() > 0
                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return false;
        }
    }
}
