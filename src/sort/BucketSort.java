package sort;

import org.junit.Test;

import java.util.Random;

/**
 * Created by jiahan on 2/20/15.
 */
public class BucketSort {

    @Test
    public void test() {
        Random random = new Random();
        int N = 20;
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = Math.abs(random.nextInt(100));
        }
        int maxVal = maxValue(sequence);
        for (int i : sequence) {
            System.out.print(i + " ");
        }
        System.out.println("========");
        int[] b = sort(sequence, maxVal);
        System.out.println("========");
        for (int i : b) {
            System.out.print(i + " ");
        }
    }
    public int[] sort(int[] sequence, int maxValue) {
        int[] buckets = new int[maxValue + 1];
        int[] sorted = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            buckets[sequence[i]]++;
        }
        int outPos = 0;

        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                sorted[outPos] = i;
                outPos++;
            }
        }
        return sorted;
    }

    public int maxValue(int[] sequence) {
        int maxValue = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] > maxValue) {
                maxValue = sequence[i];
            }
        }
        return maxValue;
    }
}
