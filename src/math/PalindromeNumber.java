package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/21/14.
 */
public class PalindromeNumber {

    public int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            if (Math.abs(reverse) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }
    @Test
    public void isPalindrome() {
        int a = 5335;
        boolean t = isPalindrome(a);
        assertEquals("failure - isPalindrome  of '5335' not right",
                true, t);
        a = 535;
        t = isPalindrome(a);
        assertEquals("failure - isPalindrome  of '535' not right",
                true, t);
        a = 5455;
        t = isPalindrome(a);
        assertEquals("failure - isPalindrome  of '5345' not right",
                false, t);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        int first = 0;
        int end = 0;
        while (x != 0) {
            first = x / div;
            end = x % 10;
            if (first != end) {
                return false;
            }
            x = x - first * div;
            x = x / 10;
            div /= 100;
        }
        return true;
    }
}
