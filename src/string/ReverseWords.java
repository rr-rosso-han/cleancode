package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/15/14.
 */
public class ReverseWords {
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
}
