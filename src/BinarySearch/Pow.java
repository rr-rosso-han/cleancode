package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/6/15.
 */
public class Pow {

    @Test
    public void pow() {
        double x = 34.00515;
        int n = -3;
        double b = pow(x, n);
        assertEquals("failure - pow of '3, 5' not right", 0.00003, b, 0.00001);
    }
    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / powHelper(x, n * (-1));
        } else {
            return powHelper(x, n);
        }
    }

    private double powHelper(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            if (n % 2 == 0) {
                double val = powHelper(x, n / 2);
                return val * val;
            } else {
                double val = powHelper(x, n / 2);
                return val * val * x;
            }
        }
    }
}
