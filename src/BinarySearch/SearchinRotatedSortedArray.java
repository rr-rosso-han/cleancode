package BinarySearch;

import org.junit.Test;

/**
 * Created by jiahan on 1/22/15.
 */
public class SearchinRotatedSortedArray {

    @Test
    public void search() {
        int[] a = {5, 1, 3};
        int b = 5;

        int c = search(a, b);

    }
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int l = 0;
        int r = A.length - 1;

        /*if (A[l] == target) {
            return l;
        }
        if (A[r] == target) {
            return r;
        }*/

        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (target == A[m]) {
                return m;
            } else if (target > A[m]) {
                if (A[m] < A[l] && target >= A[l] ) {
                    r = m;
                } else {
                    l = m;
                }
            } else {
                if (A[m] > A[l] && target < A[l]) {
                    l = m;
                } else {
                    r = m;
                }
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
}
