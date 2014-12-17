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
        String a = "abcac";
        int b = lengthOfLongestSubstringTwoDistinctOn3(a);
        assertEquals("failure - lengthOfLongestSubstringTwoDistinct  of 'abbaccddd' not right",
                3, b);
        int c = lengthOfLongestSubstringTwoDistinct(a);
        assertEquals("failure - lengthOfLongestSubstringTwoDistinct  of 'abbaccddd' not right",
                3, c);
        int d = lengthOfLongestSubstringTwoDistinctOn2(a);
        assertEquals("failure - lengthOfLongestSubstringTwoDistinct  of 'abbaccddd' not right",
                3, d);
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

    public int lengthOfLongestSubstringTwoDistinctOn2(String s) {
        Map<Character,Integer> charNum = new HashMap<Character,Integer>();
        int start = 0;
        int end = 0;
        int charType = 2;
        int maxLen = 0;
        while (end < s.length()) {
            char cur = s.charAt(end);
            //if this char is in substring already, then increase its number
            if (charNum.containsKey(cur)) {
                charNum.put(cur, charNum.get(cur) + 1);
            } else {
                charNum.put(cur, 1);
                if (charType > 0) {
                    charType--;
                } else {
                    //We need eliminate another char in substring to maintain the feasibility of the substring.
                    while (charNum.get(s.charAt(start)) > 1){
                        charNum.put(s.charAt(start), charNum.get(s.charAt(start)) - 1);
                        start++;
                    }
                    charNum.remove(s.charAt(start));
                    start++;
                }
            }
            if (maxLen < end - start + 1) {
                maxLen = end - start + 1;
            }
            end++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringKDistinct(String s) {
        int[] count = new int[256];
        int start = 0, numDistinct = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            if (count[s.charAt(end)] == 0) {
                numDistinct++;
            }
            count[s.charAt(end)]++;
            while (numDistinct > 2) {
                count[s.charAt(start)]--;
                if (count[s.charAt(start)] == 0) {
                    numDistinct--;
                }
                start++;
            }
            maxLen = Math.max(end - start + 1, maxLen);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0; //sliding window start
        int end = -1; //sliding window end
        int maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) {
                continue;
            }
            if (end >= 0 && s.charAt(end) != s.charAt(k)) {
                maxLen = Math.max(maxLen, k - start);
                start = end + 1;
            }
            end = k - 1;
        }
        return Math.max(s.length() - start, maxLen);
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
