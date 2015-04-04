package dp;

/**
 * Created by jiahan on 2/15/15.
 */
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = Math.max(sum, left[i] + right[i]);
        }
        return sum;
    }
}
