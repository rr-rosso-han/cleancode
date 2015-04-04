package interview.google;

import java.util.Arrays;

/**
 * Created by jiahan on 3/4/15.
 */
public class RemoveDuplicatesInArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        Arrays.sort(A);
        int num = 1;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] != A[i - 1]) {
                A[num++] = A[i];
            }
        }
        return num;
    }
}
