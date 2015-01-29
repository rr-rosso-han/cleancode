package BinarySearch;

/**
 * Created by jiahan on 1/22/15.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int l = 0;
        int r = A.length - 1;
        if (A[l] == target || A[r] == target) {
            return true;
        }
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (A[m] == target) {
                return true;
            } else if (A[m] > target) {
                if (A[m] == A[r]) {
                    r = m;
                } else {

                }
            } else {

            }
        }

        return false;
    }
}
