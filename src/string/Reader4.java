package string;

/**
 * Created by jiahan on 12/19/14.
 */
public class Reader4 {
    public int read4(char[] buf) {
        int size = 1;
        for (int i = 0; i < 4; i++) {
            if (i < buf.length - 1) {
                size++;
            }
        }
        return size;
    }
}
