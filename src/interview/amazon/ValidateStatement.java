package interview.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jiahan on 12/27/14.
 */
public class ValidateStatement {

    static boolean isBalanced(String input) {
        if (input == null) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (!Character.isDigit(ch) && !Character.isWhitespace(ch)) {
                if (stack.isEmpty() || map.get(stack.peek()) == null
                        || !stack.pop().equals(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
