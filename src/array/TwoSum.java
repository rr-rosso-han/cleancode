package array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jiahan on 12/15/14.
 */
public class TwoSum {
    /*
    * Two Sum
    *
    * Given an array of integers, find two numbers such that they add up to a specific
    * target number.  The function twoSum should return indices of
    * the two numbers such that they add up to the target,
    * where index1 must be less than index2. Please note that
    * your returned answers (both index1 and index2) are not zero-based.
    * You may assume that each input would have exactly one solution.
    * Input: numbers={2, 7, 11, 15}, target=9
    * Output: index1=1, index2=2
    * */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }
        int arg1 = -1;
        int arg2 = -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (map.containsKey(tmp)) {
                arg1 = map.get(tmp) + 1;
                arg2 = i + 1;
                break;
            }
            map.put(numbers[i], i);
        }
        return new int[]{arg1, arg2};
    }

    public int[] twoSumBruteForce(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }
        int arg1 = -1;
        int arg2 = -1;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    arg1 = i + 1;
                    arg2 = j + 1;
                    break;
                }
            }
        }
        return new int[]{arg1, arg2};
    }
    /*
    *
    * Similar to Question [1. Two Sum], except that the input array is already sorted in
    * ascending order.
    * */
    @Test
    public void twoSumBinarySearch() {
        int[] A = {2,6,10,20,77,100};
        int t = 22;
        int[] b = twoSumBinarySearch(A, t);
        assertArrayEquals("failure - twoSumBinarySearch  of '2,6,10,20,77,100' not right",
                new int[]{1, 4}, b);
    }
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }
        int arg1 = -1;
        int arg2 = -1;
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(numbers, target - numbers[i]);
            if (j != -1) {
                arg1 = i + 1;
                arg2 = j + 1;
                break;
            }
        }
        return new int[]{arg1, arg2};
    }

    private int binarySearch(int[] numbers, int target) {
        int l = 0;
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
