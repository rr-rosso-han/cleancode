package stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by jiahan on 2/17/15.
 */
public class MaximalRectangle {
    @Test
    public void test() {
        char[][] a = new char[1][2];
        a[0][0] = '1';
        a[0][1] = '0';
        int area = maximalRectangle(a);
        return;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rectangle = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0){
                    rectangle[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    rectangle[i][j] = matrix[i][j] == '1' ? 1 + rectangle[i - 1][j] : 0;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            int tmp = largestRectangleArea(rectangle[i]);
            maxArea = Math.max(tmp, maxArea);
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int max = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i <= len) {
            if (stack.isEmpty() || (i < len && height[i] >= height[stack.peek()])) {
                stack.push(i);
                i++;
            } else {
                int h = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * width);
            }
        }
        return max;
    }
}
