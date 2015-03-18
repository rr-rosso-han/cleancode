package string;

/**
 * Created by jiahan on 3/9/15.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        int minSize = strs[0].length();
        int minIndex = 0;
        for (int i = 1; i < len; i++) {
            if (strs[i].length() < minSize) {
                minSize = strs[i].length();
                minIndex = i;
            }
        }

        for (int i = 0; i < len; i++) {
            if (i == minIndex) {
                continue;
            }
            for (int j = 0; j < minSize; j++) {
                if (strs[i].charAt(j) != strs[minIndex].charAt(j)) {
                    minSize = j;
                    break;
                }
            }
        }

        return strs[minIndex].substring(0, minSize + 1);
    }
}
