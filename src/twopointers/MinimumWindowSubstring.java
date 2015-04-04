package twopointers;

import java.util.HashMap;

/**
 * Created by jiahan on 2/21/15.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if(S == null || S.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++) {
            if(map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            } else {
                map.put(T.charAt(i), 1);
            }
        }

        HashMap <Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
        String minWindow = null;
        int tCount = 0;

        int l = 0;
        for (int r = 0; r < S.length(); r++) {
            Character c = S.charAt(r);
            if (!map.containsKey(c)) {
                continue;
            }
            if (minWindowCounter.containsKey(c)) {
                minWindowCounter.put(c, minWindowCounter.get(c) + 1);
            } else {
                minWindowCounter.put(c, 1);
            }

            if (minWindowCounter.get(c) <= map.get(c)) {
                tCount++;
            }

            if (tCount == T.length()) {
                while (l < S.length()) {
                    Character ch = S.charAt(l);
                    if (!map.containsKey(ch)) {
                        l++;
                        continue;
                    }

                    if (minWindowCounter.get(ch) > map.get(ch)) {
                        minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
                        l++;
                        continue;
                    }
                    break;
                }

                if (minWindow == null || r - l + 1 < minWindow.length()) {
                    minWindow = S.substring(l, r + 1);
                }
            }
        }
        if (minWindow == null) {
            return "";
        }
        return minWindow;

    }
}
