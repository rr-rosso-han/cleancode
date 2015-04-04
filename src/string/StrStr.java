package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/15/14.
 */
public class StrStr {
    /*
    * Implement strStr()
    *
    * */
    @Test
    public void strStr() {
        String h = "aaaab";
        String n = "ab";
        assertEquals("failure - strStr  of 'aaaab', 'ab' not right",
                3, strStr(h, n));
    }
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j <= needle.length(); j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
        return -1;
    }
}
