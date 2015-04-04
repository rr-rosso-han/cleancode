package dp;

/**
 * Created by jiahan on 1/14/15.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        if (A == null | A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }

        int curMin = A[0];
        int curMax = A[0];
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            int tmp = curMin * A[i];
            curMin = Math.min(A[i], Math.min(tmp, curMax * A[i]));
            curMax = Math.max(A[i], Math.max(tmp, curMax * A[i]));
            result = Math.max(result, curMax);
        }
        return result;
    }
}
