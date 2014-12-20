package string;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * Created by jiahan on 12/19/14.
 */
public class ReadNChars extends Reader4{
    @Test
    public void arrayCopy() {
        char[] a = new char[]{'a', 'b', 'd', 'e'};
        char[] b = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};

        System.arraycopy(a, 0,  b, 3, 4);
        System.out.println(String.valueOf(b));

    }
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = read4(buffer);
            if (sz < 4) eof = true;
            int bytes = Math.min(n - readBytes, sz);
            System.arraycopy(buffer /* src */, 0 /* srcPos */,
                    buf /* dest */, readBytes /* destPos */, bytes /* length */);
            readBytes += bytes;
        }
        return readBytes;
    }
}
