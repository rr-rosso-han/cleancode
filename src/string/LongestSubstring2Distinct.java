package string;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/16/14.
 */
public class LongestSubstring2Distinct {
    /*
    *
    * Given a string S, find the length of the longest substring T that contains at most two
    * distinct characters.
    * */

    @Test
    public void lengthOfLongestSubstringTwoDistinct() {
        //String a = "abbac";
        //int b = lengthOfLongestSubstringTwoDistinct(a);
        //assertEquals("failure - lengthOfLongestSubstringTwoDistinct  of 'abbac' not right",
          //      4, b);
        String a = "abaccc";
        int b = lengthOfLongestSubstringTwoDistinctOn3(a);
        assertEquals("failure - lengthOfLongestSubstringTwoDistinct  of 'abbaccddd' not right",
                4, b);
    }
    public int lengthOfLongestSubstringTwoDistinctOn3(String s) {
        Set<Character> set = new HashSet<Character>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                for (int k = 0; k < subString.length(); k++) {
                    if (!set.contains(subString.charAt(k))) {
                        set.add(subString.charAt(k));
                    }
                    if (set.size() > 2) {
                        break;
                    } else {
                        maxLength = Math.max(maxLength, k + 1);
                    }
                }
                set.clear();
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0;
        int j = -1;
        int maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) {
                continue;
            }
            if (j >= 0 && s.charAt(j)) {

            }
        }
    }
    @Test
    public void subStringsDFS() {
        String a = "abc";
        List<String> B = subStringsDFS(a);
        for (String b : B) {
            System.out.println(b);
        }
    }

    private List<String> subStringsDFS(String s) {
        List<String> result = new ArrayList<String>();
        StringBuffer path = new StringBuffer();
        return subStringsHelper(result, path, s, 0);
    }

    private List<String> subStringsHelper(List<String> result,
                                         StringBuffer path,
                                         String s,
                                         int position) {
        if (!result.contains(path.toString())) {
            result.add(path.toString());
        }
        for (int i = position; i < s.length(); i++) {
            //int start = path.length();
            StringBuffer tmp = new StringBuffer();
            tmp.append(s.substring(position, i + 1));
            subStringsHelper(result, tmp, s, i + 1);
            //path.delete(start, path.length());
        }
        return result;
    }
    @Test
    public void subStrings() {
        subStrings("def");
    }
    private void subStrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                System.out.println(s.substring(i, j + 1));
            }
        }
    }
}
