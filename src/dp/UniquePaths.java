package dp;

/**
 * Created by jiahan on 1/13/15.
 */
public class UniquePaths {
    //time limit exceed 23,12
    private int backtrack(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        } else if (row >= m || col >= n) {
            return 0;
        }
        return backtrack(row + 1, col, m, n) + backtrack(row, col + 1, m, n);
    }

    public int uniquePaths(int m, int n) {
        return backtrack(0, 0, m, n);
    }
    //backtrack with memory pass oj
    public int uniquePaths2(int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                mem[i][j] = -1;
            }
        }
        return backtrack2(mem, 0, 0, m, n);
    }

    private int backtrack2(int[][] mem, int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (row >= m || col >= n) {
            return 0;
        }
        if (mem[row + 1][col] == -1) {
            mem[row + 1][col] = backtrack2(mem, row + 1, col, m, n);
        }

        if (mem[row][col + 1] == -1) {
            mem[row][col + 1] = backtrack2(mem, row, col + 1, m, n);
        }

        return mem[row + 1][col] + mem[row][col + 1];
    }

    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];
        //first col has only one path
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //first row has only one path
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
