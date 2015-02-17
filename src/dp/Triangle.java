package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 2/14/15.
 */
public class Triangle {
    @Test
    public void test() {
        List<List<Integer>> t = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        p.add(-10);
        t.add(p);
        int a = minimumTotal(t);
        return;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int rowLen = triangle.size();
        int[][] dp = new int[rowLen][rowLen];
        List<Integer> last = triangle.get(triangle.size() - 1);

        for (int i = 0; i < last.size(); i++) {
            dp[rowLen - 1][i] = last.get(i);
        }

        for (int i = rowLen - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + list.get(j);
            }
        }
        return dp[0][0];
    }
}
