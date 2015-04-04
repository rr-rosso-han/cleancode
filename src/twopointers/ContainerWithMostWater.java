package twopointers;

/**
 * Created by jiahan on 2/20/15.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int max = 0;
        int lt = 0;
        int gt = height.length - 1;
        while (lt < gt) {
            if (lt > 0 && height[lt] == height[lt - 1]) {
                lt++;
                continue;
            }
            if (gt < height.length - 1 && height[gt] == height[gt + 1]) {
                gt--;
                continue;
            }
            max = Math.max(max, (gt - lt) * Math.min(height[lt], height[gt]));
            if (height[lt] < height[gt]) {
                lt++;
            } else {
                gt--;
            }
        }
        return max;
    }
}
