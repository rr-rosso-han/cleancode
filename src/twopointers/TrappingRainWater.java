package twopointers;

/**
 * Created by jiahan on 2/21/15.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = 0;
        int r = A.length - 1;
        int res = 0;
        while(l < r) {
            int min = Math.min(A[l], A[r]);
            if(A[l] == min) {
                l++;
                while(l < r && A[l] < min) {
                    res += min - A[l];
                    l++;
                }
            } else {
                r--;
                while(l < r && A[r] < min) {
                    res += min - A[r];
                    r--;
                }
            }
        }
        return res;
    }

    public int trap2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
        }
        right[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i]);
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += Math.min(left[i], right[i]) - A[i];
        }
        return sum;
    }
}
