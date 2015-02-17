package dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/14/15.
 */
public class UniqueBinarySearchTrees {

    @Test
    public void numTrees() {
        int n = 5;
        int b = numTrees(n);
        assertEquals("failure - numTrees  of '5' not same", 42, b);
    }
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
