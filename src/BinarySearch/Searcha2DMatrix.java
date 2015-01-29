package BinarySearch;

import org.junit.Test;

/**
 * Created by jiahan on 1/20/15.
 */
public class Searcha2DMatrix {
    @Test
    public void searchMatrix() {
        int[][] a = {{1}, {3}, {5}};
        int t = 3;
        boolean r = searchMatrix(a, t);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int min = 0;
        int max = m * n - 1;

        while (min + 1 < max) {
            int mid = (min + max) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                min = mid;
            } else {
                max = mid;
            }
        }

        if (matrix[min / n][min % n] == target) {
            return true;
        }

        if (matrix[max / n][max % n] == target) {
            return true;
        }

        return false;
    }
}
