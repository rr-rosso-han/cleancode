package dp;

/**
 * Created by jiahan on 12/18/14.
 */
public class LongestPalindromicSubstring {
    /*
    * DP
    * Time: O(n^2)
    * Space: O(n)
    * */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        String result = "";
        int maxLen = 0;
        boolean[][] isPalin = isPalindrome(s);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalin[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        result = s.substring(i, j + 1);
                    }

                }
            }
        }
        return result;
    }

    private boolean[][] isPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        dp[s.length() - 1][s.length() - 1] = true;
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp;
    }

    public String longestPalindromeII(String s) {
        int start = 0;
        int end = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
