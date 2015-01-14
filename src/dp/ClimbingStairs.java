package dp;

/**
 * Created by jiahan on 1/12/15.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return getWays(dp, n);
    }

    private int getWays(int[] dp, int stairs) {
        if (stairs <= 0) {
            return 0;
        }
        if (stairs == 1) {
            return 1;
        } else if (stairs == 2) {
            return 2;
        }
        if (dp[stairs] != 0) {
            return dp[stairs];
        }

        if (dp[stairs - 1] == 0) {
            dp[stairs - 1] = getWays(dp, stairs - 1);
        }

        if (dp[stairs - 2] == 0) {
            dp[stairs - 2] = getWays(dp, stairs - 2);
        }
        dp[stairs] = dp[stairs - 1] + dp[stairs - 2];
        return dp[stairs];
    }

}
