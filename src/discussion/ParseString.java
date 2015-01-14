package discussion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jiahan on 1/10/15.
 */
public class ParseString {
    /*
    * Parse a formula string (only contains "+-()", no "\*\/"), for example,   “
    *        5 + 2x – ( 3y + 2x  - ( 7 – 2x) – 9 ) = 3 + 4y”, parse this string, with
    *a given float of ‘x’ value, output a float for ‘y’ value.
    * */
    public float parseString(String str, float x) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        StringBuffer result = new StringBuffer();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            Character item = str.charAt(i);
            if (!Character.isDigit(item)) {
                if (item == '+') {

                } else if (item == '-') {

                } else if (item == ')') {

                }
            }

            stack.push(item);
        }
        return 1;
    }
}