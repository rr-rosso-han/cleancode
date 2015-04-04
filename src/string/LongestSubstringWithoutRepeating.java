package string;

//import com.sun.javafx.image.IntPixelGetter;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/15/14.
 */
public class LongestSubstringWithoutRepeating {

    @Test
    public void lengthOfLongestSubstring() {
        String s = "abcdcefgehih";
        int a = lengthOfLongestSubstring(s);
        assertEquals("failure - lengthOfLongestSubstring  of 'abcdcefgehih' not right",
                5, a);

    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        boolean[] exist = new boolean[256];
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (exist[s.charAt(right)]) {
                exist[s.charAt(left)] = false;
                left++;
            }
            exist[s.charAt(right)] = true;
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringQueue(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Queue<Character> queue = new LinkedList<Character>();
        int i = 0;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            while (queue.contains(s.charAt(j))) {
                queue.poll();
                i++;
            }
            queue.offer(s.charAt(j));
            maxLength = Math.max(j - i + 1, maxLength);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringOneLoop(String s) {
        int i = 0;
        int n = s.length();
        int maxLength = 0;
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        for (int j = 0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLength = Math.max(j - i + 1, maxLength);
        }
        return maxLength;
    }
}
