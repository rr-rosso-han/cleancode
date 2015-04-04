package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/19/14.
 */
public class OneEditDistance {
    @Test
    public void isOneEditDistance() {
        String s = "abcdef";
        String t = "abcxdef";
        boolean c = isOneEditDistance(s, t);
        assertEquals("failure - isOneEditDistance  of 'abcdef' and 'abcxdef' not right",
                true, c);
    }
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        if (n - m > 1) {
            return false;
        }
        int i = 0;
        int shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        if (i == m) {
            return shift > 0;
        }
        if (shift == 0) {
            i++;
        }
        while (i < m && s.charAt(i) == t.charAt(i + shift)) {
            i++;
        }
        return i == m;
    }


}
