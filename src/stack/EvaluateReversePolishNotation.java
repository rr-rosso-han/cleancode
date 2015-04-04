package stack;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 1/12/15.
 */
public class EvaluateReversePolishNotation {
    @Test
    public void evalRPN() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int a = evalRPN(tokens);
        assertEquals("failure - evalRPN  of '9' not right",
                9, a);
    }
    private static final Set<String> OPERATORS2 = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        int n = tokens.length;
        int arg1 = 0;
        int arg2 = 0;
        int result = 0;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < n; i++) {
            String str = tokens[i];
            if (OPERATORS2.contains(str)) {
                if (!stack.isEmpty()) {
                    arg2 = Integer.valueOf(stack.pop());
                }
                if (!stack.isEmpty()) {
                    arg1 = Integer.valueOf(stack.pop());
                }
                result = eval(arg1, arg2, str);
                stack.push(String.valueOf(result));
            } else {
                stack.push(str);
            }
        }
        return Integer.valueOf(stack.peek());
    }

    private int eval(int x, int y, String opt) {
        switch (opt) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            default: return x / y;
        }
    }

    interface Operator {
        int eval(int x, int y);
    }
    private static final Map<String, Operator> OPERATORS =
            new HashMap<String, Operator>() {{
                put("+", new Operator() {
                    public int eval(int x, int y) { return x + y; }
                });
                put("-", new Operator() {
                    public int eval(int x, int y) { return x - y; }
                });
                put("*", new Operator() {
                    public int eval(int x, int y) { return x * y; }
                });
                put("/", new Operator() {
                    public int eval(int x, int y) { return x / y; }
                });
            }};
    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.containsKey(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(OPERATORS.get(token).eval(x, y));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
