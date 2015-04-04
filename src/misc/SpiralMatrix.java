package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 1/4/15.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = -1;

        while (true) {
            for (int i = 0; i < n; i++) {
                result.add(matrix[row][++col]);
            }
            if (--m == 0) {
                break;
            }
            for (int j = 0; j < m; j++) {
                result.add(matrix[++row][col]);
            }
            if (--n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                result.add(matrix[row][--col]);
            }
            if (--m == 0) {
                break;
            }
            for (int j = 0; j < m; j++) {
                result.add(matrix[--row][col]);
            }
            if (--n == 0) {
                break;
            }
        }

        return result;
    }
}
