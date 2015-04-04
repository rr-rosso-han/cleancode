package topcoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 1/7/15.
 */
public class BadNeighbors {
    /**
     *
     * bug is don't know it need to be dp[i - 2] + donations[i]
     *
     *
     */
    @Test
    public void maxDonations() {
        int[] a = {10, 3, 2, 5, 7, 8};
        int a1 = 19;
        int[] b = {11, 15};
        int b1 = 15;
        int[] c = {7, 7, 7, 7, 7, 7, 7};
        int c1 = 21;
        int[] d = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int d1 = 16;
        int[] e = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
        int e1 = 2926;

        assertEquals("failure - maxDonations  of 'a' is not right", a1, maxDonations(a));
        assertEquals("failure - maxDonations  of 'b' is not right", b1, maxDonations(b));
        assertEquals("failure - maxDonations  of 'c' is not right", c1, maxDonations(c));
        assertEquals("failure - maxDonations  of 'd' is not right", d1, maxDonations(d));
        assertEquals("failure - maxDonations  of 'e' is not right", e1, maxDonations(e));
    }

    public int maxDonations(int[] donations) {
        int n = donations.length;
        //init
        int[] dp = new int[n];
        dp[0] = donations[0];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + donations[i], dp[i - 1]);
        }
        int answer1 = dp[n - 2];

        dp = new int[n];
        dp[1] = donations[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + donations[i], dp[i - 1]);
        }
        int answer2 = dp[n - 1];
        return Math.max(answer1, answer2);
    }

}
