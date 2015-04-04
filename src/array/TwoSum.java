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

}
