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

    public int reverseBinary(int x) {
        /*
        * 奇数偶数交换
        * 12,23位整体换
        * 4位交换
        * 8位交换
        * 16位交换
        * */
        return 1;
    }
}
