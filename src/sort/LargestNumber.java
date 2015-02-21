package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jiahan on 2/20/15.
 */
public class LargestNumber {

    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        List<String> list = new ArrayList<String>();
        for (int i : num) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list, new StringComparator());
        boolean HasPossibleLeading0 = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (HasPossibleLeading0 && list.get(i).equals("0"))
                continue;
            HasPossibleLeading0 = false;
            sb.append(list.get(i));
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String A = o1 + o2;
            String B = o2 + o1;
            return B.compareTo(A);
        }
    }
}
