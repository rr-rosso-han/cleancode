package string;

/**
 * Created by jiahan on 3/23/15.
 */
public class Read4II extends Reader4 {
    private char[] buffer = new char[4];
    int offset = 0, bufSize = 0;

    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            if (bufSize == 0) {
                bufSize = read4(buffer);
                eof = bufSize < 4;
            }
            int bytes = Math.min(n - readBytes, bufSize);
            System.arraycopy(buffer /* src */, offset /* srcPos */,
                    buf /* dest */, readBytes /* destPos */, bytes /* length */);
            offset = (offset + bytes) % 4;
            bufSize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
}
