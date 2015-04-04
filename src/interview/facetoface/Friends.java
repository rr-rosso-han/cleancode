package interview.facetoface;

/**
 * Created by jiahan on 1/23/15.
 */
public class Friends {

    public int findLeader(int[] A) {
        boolean[] isLeader = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            int c = A[i];
            for (int j = 0; j < A.length; j++) {
                if ( i != j) {
                    if (isFriend(c, A[j]) || !isFriend(A[j], c)) {
                        isLeader[i] = false;
                    } else {
                        isLeader[i] = true;
                    }
                }
            }
        }
        int leaders = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (isLeader[i]) {
                leaders++;
                index = i;
            }
        }
        return leaders == 1 ? index : -1;
    }

    private boolean isFriend(int a, int b) {
        return true;
    }
}
