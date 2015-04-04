package stack;

import java.util.Stack;

/**
 * Created by jiahan on 2/17/15.
 */
public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int len = height.length;
        int i = 0;
        int max = 0;
        while (i <= len) {
            if (stack.isEmpty() || i < len && height[i] >= height[stack.peek()]) {
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
