package string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/14/14.
 */
public class Solution {



    @Test
    public void reverseWords() {
        String a = " a b cde abc   ";
        String ret = reverseWords(a);
        assertEquals("failure - reverseWords  of ' a b cde abc   ' not right",
                "abc cde b a", ret);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuffer reversed = new StringBuffer();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }
    @Test
    public void reverseWordsInPlace() {
        String s = "a b c def";
        String b = reverseWordsInPlace(s);
        assertEquals("failure - reverseWordsInPlace  of 'a b c def' not right",
                "def c b a", b);
    }
    public String reverseWordsInPlace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] a = s.toCharArray();
        reverse(a, 0, a.length);
        for (int i = 0, j = 0; j <= a.length; j++) {
            if (j == a.length || a[j] == ' ') {
                reverse(a, i, j);
                i = j + 1;
            }
        }
        return String.valueOf(a);
    }
    @Test
    public void reverse() {
        String s = "abcd";
        char[] a = s.toCharArray();
        reverse(a, 0, a.length);
        assertEquals("failure - reverse  of 'abcd' not right",
                "dcba", String.valueOf(a));
    }
    private void reverse(char[] s, int begin, int end) {
        int j = end - 1;
        for (int i = begin; i <= begin + (end - begin - 1) / 2; i++) {
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            j--;
        }
    }

    @Test
    public void atoi() {
        String a = "2147483648";
        int b = atoi(a);
        assertEquals("failure - atoi  of '2147483648' not right",
                2147483647, b);
    }
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        int n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (num > maxDiv10 || (num == maxDiv10 && digit >= 8)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

    public boolean isNumber(String s) {
        return false;
    }
}
