package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 1/14/15.
 */
public class FindMinimuminSortedRotatedArray {

    @Test
    public void findMin() {
        int[] a = {1, 2, 3};
        int[] a1 = {2, 1};
        int[] a2 = {5,1,2,3,4};
        int[] a3 = {3, 1, 2};
        int e = findMin(a3);
        int d = findMin(a2);
        int c = findMin(a1);
        int b = findMin(a);
        assertEquals("failure - findMin  of '312' not right", 1, e);
        assertEquals("failure - findMin  of '51234' not right", 1, d);
        assertEquals("failure - findMin  of '2, 1' not right", 1, c);
        assertEquals("failure - findMin  of '1, 2, 3' not right", 1, b);
    }

    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }

        if (num.length == 2) {
            return num[0] < num[1] ? num[0] : num[1];
        }

        int l = 0;
        int r = num.length - 1;
        if (num[0] <= num[l + (r - l) / 2] && num[l + (r - l) / 2] <= num[num.length - 1]) {
            return num[0];
        }
        while(l + 1 <= r) {
            int m = l + (r - l) / 2;
            if (num[m] > num[m + 1]) {
                return num[m + 1];
            } else if (num[m] < num[0]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return num[l];
    }

}
