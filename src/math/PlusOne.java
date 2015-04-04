package math;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jiahan on 12/19/14.
 */
public class PlusOne {
    @Test
    public void plusOne() {
        int[] a = {9};
        int[] b = plusOne(a);
        assertArrayEquals("failure - plusOne  of '9' not right",
                new int[]{1, 0}, b);
        a = new int[]{8, 9, 9, 9};
        b = plusOne(a);
        assertArrayEquals("failure - plusOne  of '8,9,9,9' not right",
                new int[]{9,0,0,0}, b);
    }
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int carrier = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (i == digits.length - 1) {
                if (digit < 9) {
                    digits[i] = digit + 1;
                    return digits;
                } else {
                    digits[i] = 0;
                    carrier = 1;
                }
            } else {
                if (digit == 9 && carrier == 1) {
                    digits[i] = 0;
                    carrier = 1;
                } else {
                    digits[i] = digit + carrier;
                    carrier = 0;
                }
            }
        }
        if (carrier == 1) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            System.arraycopy(digits, 0, ret, 1, digits.length);
            return ret;
        } else {
            return digits;
        }
    }
}
