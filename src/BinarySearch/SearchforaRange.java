package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jiahan on 1/21/15.
 */
public class SearchforaRange {

    @Test
    public void searchRange() {
        int[] a = {1,4,5,5,5,5,8,32,77};
        int[] a1 = {1,3};
        int[] a2 = {1, 2, 2};
        int[] b = {2, 5};
        int[] c = {0, 0};
        int[] d = {1, 2};
        assertArrayEquals("failure - searchRange of '1, 2, 2' not right",
                d, searchRange(a2, 2));
        assertArrayEquals("failure - searchRange of '1, 3' not right",
                c, searchRange(a1, 1));
        assertArrayEquals("failure - searchRange of '1,4,5,5,5,5,8,32,77' not right",
                b, searchRange(a, 5));
    }

    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int left = findLeft(A, target, 0, A.length - 1);
        int right = findRight(A, target, 0, A.length - 1);
        return new int[]{left, right};
    }

    private int findLeft(int[] A, int target, int l, int r) {
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (target > A[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (A[l] == target) {
            return l;
        }
        if (A[r] == target) {
            return r;
        }
        return -1;
    }

    private int findRight(int[] A, int target, int l, int r) {
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (target < A[mid]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (A[r] == target) {
            return r;
        }
        if (A[l] == target) {
            return l;
        }
        return -1;
    }
}
