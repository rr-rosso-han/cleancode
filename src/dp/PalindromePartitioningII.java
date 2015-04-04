package dp;

/**
 * Created by jiahan on 2/18/15.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalin = new boolean[len][len];

        for (int i = len - 1; i >=0; i--) {
            cuts[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                isPalin[i][j] = false;
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalin[i + 1][j - 1])) {
                    isPalin[i][j] = true;
                    if (j == len - 1) {
                        cuts[i] = 0;
                    } else {
                        cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                    }
                }
            }

        }
        return cuts[0];
    }
}
