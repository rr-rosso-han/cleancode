package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 1/19/15.
 */
public class RestoreIPAddresses {

    @Test
    public void restoreIpAddresses() {
        String s = "010010";
        String ss = "0000";
        List<String> b = restoreIpAddresses(ss);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        if (s == null || s.length() == 0) {
            result.add(new String(path));
            return result;
        }
        restoreIpAddressesHelper(result, path, s, 0, 0);
        return result;
    }

    private void restoreIpAddressesHelper(List<String> result,
                                          StringBuffer path,
                                          String s,
                                          int pathNum,
                                          int pos) {
        if (pathNum >= 4 && pos < s.length()) {
            return;
        }
        if (pathNum == 4 && pos == s.length()) {
            String str = path.toString().substring(path.length() - 1, path.length());
            result.add(str);
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String tmp = s.substring(pos, i + 1);
            if (isValid(tmp)) {
                path.append(tmp).append(".");
                pathNum++;
                restoreIpAddressesHelper(result, path, s, pathNum, i + 1);
                pathNum--;
                path.delete(path.length() - tmp.length() - 1, path.length());
            }
        }

    }
    private boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int number = 0;
        try {
            number = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }

        if (number >= 0 && number <= 255) {
            return true;
        }
        return false;
    }
}
