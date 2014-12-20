package math;

/**
 * Created by jiahan on 12/19/14.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int ret = 0;
        int number = 0;
        while (x != 0) {
            if (Math.abs(ret) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            number = x % 10;
            ret = ret * 10 + number;
            x = x / 10;
        }
        return ret;
    }
}
