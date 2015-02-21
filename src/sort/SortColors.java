package sort;

/**
 * Created by jiahan on 2/19/15.
 */
public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return;
        }
        sortColors(A, 0, A.length - 1);
    }
    private void exch(int[] A, int l, int r) {
        if (l != r) {
            int t = A[l];
            A[l] = A[r];
            A[r] = t;
        }
    }

    private void sortColors(int[] A, int low, int hi) {
        int key = 1;
        int i = 0;
        int lt = low;
        int gt = hi;
        while (i <= gt) {
            if (A[i] < key) {
                exch(A, lt, i);
                lt++;
                i++;
            } else if (A[i] > key) {
                exch(A, gt, i);
                gt--;
            } else {
                i++;
            }
        }
    }
}
