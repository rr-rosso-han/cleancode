package string;

/**
 * Created by jiahan on 3/9/15.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len <= nRows || nRows == 1) {
            return s;
        }

        char[] c = new char[len];
        int size = 2 * nRows - 2;
        int count = 0;
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < len; j += size) {
                c[count] = s.charAt(j);
                count++;
                int mid = j + size - i * 2;
                if (i != 0 && i != nRows - 1 && mid < len) {
                    c[count] = s.charAt(mid);
                    count++;
                }
            }
        }
        return new String(c);
    }
}
