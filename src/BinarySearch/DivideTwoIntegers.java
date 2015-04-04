package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/9/15.
 */
public class DivideTwoIntegers {
    @Test
    public void test() {
        int d1 = -2147483648;
        int d2 = -1;
        int r = divide(d1, d2);
        assertEquals("failure - divide of '9, 3' not right", 3, r);
    }
    int result = 0;
    int mod = 0;
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == 1 || divisor == -1){
            return dividend * divisor;
        }

        if(divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean isMin = dividend == Integer.MIN_VALUE ? true : false;
        dividend = dividend == Integer.MIN_VALUE ? (dividend + 1) : dividend;

        int flag = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;

        dividend = dividend < 0 ? dividend * -1 : dividend;
        divisor = divisor < 0 ? divisor * -1 : divisor;
        reverse(dividend, divisor);
        if(isMin){
            mod++;
            result = mod >= divisor ? result + 1 : result;
        }
        return result * flag;
    }

    private void reverse(int dividend,int divisor){
        if (dividend > divisor){
            int dividend2 = dividend >> 1;
            reverse(dividend2, divisor);
            mod = dividend - (dividend2 << 1) + mod + mod;
            result = mod >= divisor ? ((result << 1) + 1) : (result << 1);
            mod = mod < divisor ? mod : (mod - divisor);
        } else if( dividend == divisor){
            result = 1;
            mod = 0;
        } else {
            mod = dividend;
            result = 0;
        }
    }
}
