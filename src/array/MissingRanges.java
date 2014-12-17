package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiahan on 12/17/14.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> ranges = new ArrayList<String>();
        if (A == null || A.length == 0) {
            ranges.add(getRange(lower, upper));
            return ranges;
        }
        int n = A.length;
        int prev = lower - 1;
        for (int i = 0; i <= n; i++) {
            int curr;
            if (i == n) {
                curr = upper + 1;
            } else {
                curr = A[i];
            }
            if (curr - prev >= 2) {
                ranges.add(getRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return ranges;
    }

    private String getRange(int from, int to) {
        if (from == to) {
            return String.valueOf(from);
        } else {
            return from + "->" + to;
        }
    }
}
