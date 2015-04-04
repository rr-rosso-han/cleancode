package string;

/**
 * Created by jiahan on 3/8/15.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        if (k % len == 0) {
            return;
        } else {
            k = k % len;
            reverse(nums, 0, len - k - 1);
            reverse(nums, len - k, len - 1);
            reverse(nums, 0, len - 1);
        }
        return;
    }

    private void reverse(int[] s, int begin, int end) {
        int tmp;
        while (begin < end) {
            tmp = s[end];
            s[end] = s[begin];
            s[begin] = tmp;
            begin++;
            end--;
        }
    }
}
