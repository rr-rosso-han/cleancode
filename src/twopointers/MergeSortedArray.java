package twopointers;

import org.junit.Test;

/**
 * Created by jiahan on 2/21/15.
 */
public class MergeSortedArray {
    @Test
    public void test() {
        int[] a = {23, 45, 556, 6667, -1, -1, -1};
        int[] b = {1, 444, 600};
        merge(a, 4, b, 3);
        return;
    }

    public void merge(int A[], int m, int B[], int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int i = A.length - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (A[indexA] > B[indexB]) {
                A[i] = A[indexA--];
            } else {
                A[i] = B[indexB--];
            }
            i--;
        }
        while (indexA >= 0) {
            A[i--] = A[indexA--];
        }
        while (indexB >= 0) {
            A[i--] = B[indexB--];
        }
    }
}
