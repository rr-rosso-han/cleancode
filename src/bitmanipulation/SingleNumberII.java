package bitmanipulation;

/**
 * Created by jiahan on 1/2/15.
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (1 == ((A[j] >> i) & 1)) {
                    count[i]++;
                }
            }
            result |= (count[i] % 3) << i;
        }
        return result;
    }

    public int singleNumber2(int[] A) {
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i = 0; i < A.length; i++) {
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
