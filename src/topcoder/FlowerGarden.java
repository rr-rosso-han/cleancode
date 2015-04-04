package topcoder;

import org.junit.Test;

/**
 * Created by jiahan on 1/8/15.
 */
public class FlowerGarden {

    @Test
    public void getOrdering() {
        int[] a = {1,2,3,4,5};
        int[] b = {10,33,5,2,43};
        int[] c = {15,34,22,44,66};

        int[] t = getOrdering(a, b, c);
    }
    public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
        int n = height.length;
        int[] h = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int maxHigh = 0;
            int pos = -1;
            for (int j = 0; j < n; j++) {
                if (used[j]) continue;
                boolean found = true;
                for (int k = 0; k < n; k++) {
                    if (used[k]) continue;
                    boolean blocking = !(bloom[j] > wilt[k] || bloom[k] > wilt[j]);
                    if (height[j] > height[k] && blocking) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    if (height[j] > maxHigh) {
                        maxHigh = height[j];
                        pos = j;
                    }
                }
            }
            h[i] = height[pos];
            used[pos] = true;
        }
        return h;
    }
}
