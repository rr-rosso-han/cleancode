package topcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 1/7/15.
 */
public class ZigZag {
    @Test
    public void longestZigZag() {
        int[] a = {1, 7, 4, 9, 2, 5};
        int a1 = 6;
        int[] b = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int b1 = 7;
        int[] c = {44};
        int c1 = 1;
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int d1 = 2;
        int[] e = {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
        int e1 = 8;
        int[] f = {374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244};
        int f1 = 36;
        assertEquals("failure - longestZigZag  of 'a' not right", a1, longestZigZag(a));
        assertEquals("failure - longestZigZag  of 'b' not right", b1, longestZigZag(b));
        assertEquals("failure - longestZigZag  of 'c' not right", c1, longestZigZag(c));
        assertEquals("failure - longestZigZag  of 'd' not right", d1, longestZigZag(d));
        assertEquals("failure - longestZigZag  of 'e' not right", e1, longestZigZag(e));
        assertEquals("failure - longestZigZag  of 'f' not right", f1, longestZigZag(f));
    }
    int maxLen = 0;
    public int longestZigZag(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        int n = A.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] - A[j] > 0) {
                    dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
                } else if (A[i] - A[j] < 0) {
                    dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
                }
            }
        }
        return Math.max(dp[n - 1][1], dp[n - 1][0]);
    }
}
