package string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/17/14.
 */
public class LongestPalindromicSubstring {
    /*
    * Longest Palindromic Substring
    * Given a string S, find the longest palindromic substring in S. You may assume that the
    * maximum length of S is 1000, and there exists one unique longest palindromic substring.
    * */
    @Test
    public void longestPalindrome() {
        String a = "ccdeefabaabadcaba";
        String b = longestPalindrome(a);
        assertEquals("failure - longestPalindrome  of 'ccdeefabaabadcaba' not right",
                "abaaba", b);
    }
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (isPalindrome(subString)) {
                    if ((j - i) > maxLength) {
                        maxLength = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
    @Test
    public void isPalindrome() {
        String a = "abba";
        boolean b = isPalindrome(a);
        assertEquals("failure - isPalindrome  of 'abba' not right",
                true, b);
        a = "aba";
        b = isPalindrome(a);
        assertEquals("failure - isPalindrome  of 'aba' not right",
                true, b);
    }
    private boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        int mid = (right - left) / 2;

        for (int i = left; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }
}
