package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jiahan on 12/27/14.
 */
public class ValidParentheses {

    public void isValid() {

    }
    public boolean isValid(String s) {
        if (s == null && s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');

        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if ('(' == ch || '[' == ch) {
                stack.push(ch);
            } else if (!Character.isDigit(ch) && !Character.isWhitespace(ch)) {
                Character tmp = stack.peek();
                if (!Character.valueOf(ch).equals(map.get(tmp))) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
