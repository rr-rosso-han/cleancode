package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/5/15.
 */
public class Sqrt {
    @Test
    public void sqrt() {
        int a = 7;
        int b = sqrt(a);
        assertEquals("failure - sqrt of '7' not right",
                2, b);
    }
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        int l = 0;
        int r = x;

        while (l <= r) {
            int mid = (r + l) / 2;
            int n = x / mid;
            int o = x % mid;
            if (n == mid && o == 0) {
                return mid;
            }
            if (n >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public int sqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        double last = 0;
        double res = x;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}
