package backtrack;

import com.sun.corba.se.spi.activation._RepositoryStub;
import org.junit.Test;
import sun.net.www.content.audio.basic;

import java.util.ArrayList;

/**
 * Created by jiahan on 12/26/14.
 */
public class GrayCode {

    @Test
    public void grayCode() {
        int n = 3;
        ArrayList<Integer> b = grayCode(n);
    }
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        ArrayList<Integer> tmp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            int code = addNumber + tmp.get(i);
            result.add(code);
        }
        return result;
    }

    private void backTrack(ArrayList<Integer> result, int n, int k) {
        if (k == Math.pow(2, n)) {
            return;
        }
        result.add(k);
        backTrack(result, n, k + 1);
    }
}
