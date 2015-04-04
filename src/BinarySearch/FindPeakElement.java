package BinarySearch;

/**
 * Created by jiahan on 2/8/15.
 */
public class FindPeakElement {

    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException("input cannot be null");
        }
        if (num.length == 1) {
            return 0;
        }

        int l = 0;
        int r = num.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            //peak return
            if (num[m - 1] < num[m] && num[m] > num[m + 1]) {
                return m;
            }
            if (num[m - 1] < num[m] && num[m] < num[m + 1]) {
                l = m;
            } else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {
                r = m;
            } else {
                r = m;
            }
        }

        return num[l] < num[r] ? r : l;
    }
}
