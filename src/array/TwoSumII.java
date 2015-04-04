package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jiahan on 12/25/14.
 */
public class TwoSumII {

    /*
    *
    * Similar to Question [1. Two Sum], except that the input array is already sorted in
    * ascending order.
    * */
    @Test
    public void twoSum() {
        int[] A = {1,2,3,4,4,9,56,90};
        int t = 8;
        int[] b = twoSum(A, t);
        assertArrayEquals("failure - twoSumBinarySearch  of '1,2,3,4,4,9,56,90' not right",
                new int[]{4, 5}, b);
    }
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }
        int arg1 = -1;
        int arg2 = -1;
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(numbers, target - numbers[i], i + 1);
            if (j != -1) {
                arg1 = i + 1;
                arg2 = j + 1;
                break;
            }
        }
        return new int[]{arg1, arg2};
    }

    private int binarySearch(int[] numbers, int target, int start) {
        int l = start;
        int r = numbers.length - 1;
        int m = l;
        while (l + 1 < r) {
            m = l + (r - l) / 2;
            if (numbers[m] == target) {
                return m;
            } else if (numbers[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }

        if (numbers[l] == target) {
            return l;
        }
        if (numbers[r] == target) {
            return r;
        }
        return -1;
    }

    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
