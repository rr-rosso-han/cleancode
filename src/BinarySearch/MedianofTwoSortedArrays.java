package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 2/6/15.
 */
public class MedianofTwoSortedArrays {

    @Test
    public void find() {
        int[] a = {1};
        int[] b = {1};
        double c = findMedianSortedArrays(a, b);
        assertEquals("failure - findMedianSortedArrays  of '1.0' not right", 1.0, c, 0.001);
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (getMedian(A, 0, B, 0, len / 2) + getMedian(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return getMedian(A, 0, B, 0, len / 2 + 1);
        }
    }


    private double getMedian(int A[], int startA, int B[], int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int keyA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;

        if (keyA < keyB) {
            return getMedian(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return getMedian(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
}
