package dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 1/14/15.
 */
public class MaximumSumSubarray {

    @Test
    public void maxSubArray() {
        int[] a = {4, 5, -1, -2, 3, 4};
        int b = maxSubArray(a);
        assertEquals("failure - maxSubArray  of '13' not right", 13, b);
    }
    @Test
    public void maxSubArray2() {
        int[] a = {4, 5, -1, -2, 3, 4};
        int c = maxSubArray2(a);
        assertEquals("failure - maxSubArray  of '13' not right", 13, c);
    }
    public int maxSubArray(int[] A) {
        int sum = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(sum + A[i], A[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray2(int[] A) {
        int sum = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = sum < 0 ? A[i] : sum + A[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
