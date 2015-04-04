package dp;

/**
 * Created by jiahan on 2/17/15.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int lenS = s.length();
        int lenP = p.length();

        boolean[][] dp = new boolean[lenP + 1][lenS + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lenP; i++) {
            if (p.charAt(i - 1) == '*') {
                int j = lenS + 1;
                for (int k = 0; k <= lenS; k++) {
                    if (dp[i - 1][k]) {
                        j = k;
                    }
                    for (; j <= lenS; j++) {
                        dp[i][j] = true;
                    }
                }
            } else {
                for (int j = 1; j <= lenS; j++) {
                    if (dp[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')) {
                        dp[i][j] = true;
                    }
                }
            }
            dp[i][0] = dp[i - 1][0] && (p.charAt(i - 1) == '*');
        }

        return dp[lenP][lenS];
    }

    public boolean isMatch2(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return false;
        }

        int lenS = s.length();
        int lenP = p.length();
        boolean[] dp = new boolean[lenS + 1];
        dp[0] = true;
        int count = 0;
        for (int pi = 0; pi < lenP; pi++) {
            if (p.charAt(pi) != '*') {
                count++;
            }
        }
        if (count > lenS) {
            return false;
        }

        for (int pi = 1; pi <= lenP; pi++) {
            if (p.charAt(pi - 1) == '*') {
                int j = lenS + 1;
                for (int k = 0; k <= lenS; k++) {
                    if (dp[k]) {
                        j = k;
                        break;
                    }
                }
                for (; j <= lenS; j++) {
                    dp[j] = true;
                }
            } else {
                for (int si = lenS; si >= 1; si--) {
                    dp[si] = dp[si - 1] && (p.charAt(pi - 1) == s.charAt(si - 1) || p.charAt(pi - 1) == '?');
                }
            }
            dp[0] = dp[0] && (p.charAt(pi - 1) == '*');
        }
        return dp[lenS];
    }
}
