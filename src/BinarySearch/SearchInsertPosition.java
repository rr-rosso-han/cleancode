package BinarySearch;

import org.junit.Test;
import sun.print.resources.serviceui;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 1/14/15.
 */
public class SearchInsertPosition {
    @Test
    public void searchInsert() {
        int[] a1 = {1,3,5,6};
        int t1 = 5;
        int b = searchInsert(a1, t1);
        assertEquals("failure - searchInsert  of '5' not right", 2, b);

        int t2 = 2;
        int c = searchInsert(a1, t2);
        assertEquals("failure - searchInsert  of '2' not right", 1, c);

        int t3 = 7;
        int d = searchInsert(a1, t3);
        assertEquals("failure - searchInsert  of '7' not right", 4, d);

        int t4 = 0;
        int e = searchInsert(a1, t4);
        assertEquals("failure - searchInsert  of '0' not right", 0, e);
    }
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
