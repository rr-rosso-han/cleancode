package twopointers;

/**
 * Created by jiahan on 2/20/15.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        int num = 1;
        int counter = 1;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && counter == 2 && A[i] == A[i - 1]) {
                continue;
            }
            if (i > 0 && counter < 2 && A[i] == A[i - 1]) {
                A[num++] = A[i];
                counter++;
            }
            if (i > 0 && A[i] != A[i - 1]) {
                counter = 1;
                A[num++] = A[i];
            }
        }
        return num;
    }
}
