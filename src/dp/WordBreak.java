package dp;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/13/15.
 */
public class WordBreak {
    @Test
    public void wordBreak() {
        Set<String> dict = new HashSet<String>();
        String a = "dogs";
        dict.add("dog");
        dict.add("s");
        dict.add("gs");
        assertEquals("failure - wordBreak  of 'dogs' not same", true, wordBreak(a, dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
