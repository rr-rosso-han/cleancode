package dp;

/**
 * Created by jiahan on 2/14/15.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i] = 0;
            int index = i - 1;
            if (isValidOne(s.charAt(i))) {
                dp[i] += dp[i - 1];
            }

            if (i >= 2 && isValidTwo(s.substring(i - 1, i + 1))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    private boolean isValidOne(char c) {
        if (c >= '1' && c <= '9') {
            return true;
        }
        return false;
    }

    private boolean isValidTwo(String s) {
        int num = Integer.parseInt(s);
        if (num >= 10 && num <= 26) {
            return true;
        }
        return false;
    }
}
