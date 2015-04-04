package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/19/14.
 */
public class RotateString {

    @Test
    public void Rotate() {
        String a = "abcdef";
        String b = leftRotate(a, 2);
        assertEquals("failure - leftRotate  of 'abcdef' not right",
                "cdefab", b);
        String c = rightRotate(a, 2);
        assertEquals("failure - rightRotate  of 'abcdef' not right",
                "efabcd", c);
    }
    public String leftRotate(String s, int n) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        char[] a = s.toCharArray();
        reverse(a, 0, n - 1);
        reverse(a, n, len - 1);
        reverse(a, 0, len - 1);

        return String.valueOf(a);
    }

    private void reverse(char[] s, int begin, int end) {
        char tmp;
        while (begin < end) {
            tmp = s[end];
            s[end] = s[begin];
            s[begin] = tmp;
            begin++;
            end--;
        }
    }

    public String rightRotate(String s, int n) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        char[] a = s.toCharArray();
        reverse(a, 0, len - n - 1);
        reverse(a, len - n, len - 1);
        reverse(a, 0, len - 1);

        return String.valueOf(a);
    }
}
