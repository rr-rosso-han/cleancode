package string;

import com.sun.javafx.image.IntPixelGetter;
import org.junit.Test;

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
        int i = 0;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLength = Math.max(j - i + 1, maxLength);
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
}
