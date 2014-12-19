package string;

import org.junit.Test;

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
    @Test
    public void longestPalindromeOn2() {
        String a = "lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuqbmtzwdkihbwkrjefrsgjbrycembzzlwhxneiijgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcvawaiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekeaxezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbezoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgvavqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlowslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlolsltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlvkhwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhwargbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpvdiwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzuprywlypxeezaxoqfges";
        String b = longestPalindromeOn2(a);
        assertEquals("failure - longestPalindromeOn2  of 'abccdaadba' not right",
                "pnnp", b);
        a = "a";
        b = longestPalindromeOn2(a);
        assertEquals("failure - longestPalindromeOn2  of 'a' not right",
                "a", b);
    }

    public String longestPalindromeOn2(String s) {
        int start = 0;
        int end = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
