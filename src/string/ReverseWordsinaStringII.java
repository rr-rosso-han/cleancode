package string;

/**
 * Created by jiahan on 3/8/15.
 */
public class ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) {
            return;
        }
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
        return;
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
