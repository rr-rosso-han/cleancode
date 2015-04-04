package interview.amazon;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiahan on 12/26/14.
 */
public class Parentheses {
    @Test
    public void test() {
        String a = "([5 2 ] 12 )";
        String b = "40 [12 23 [4 5 ( 12 ) ) ]";
        boolean t1 = isBalanced(a);
        boolean t2 = isBalanced(b);
        assertEquals("failure - longestPalindromeOn2  of 't1' not right",
                true, t1);

        assertEquals("failure - longestPalindromeOn2  of 't2' not right",
                false, t2);
    }

    static boolean isBalanced2(String input) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (!Character.isDigit(ch) && !Character.isWhitespace(ch)){
                Character another = map.get(stack.pop());
                if (stack.isEmpty() || another == null || !another.equals(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (!Character.isDigit(ch) && ch != ' '){
                if (stack.isEmpty() || !Character.valueOf(ch).equals(map.get(stack.peek()))) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test2() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        //LinkedListNode t1 = getMid(n1);
        //assertEquals("failure - longestPalindromeOn2  of 't1' not right",
        //        3, t1.val);

        LinkedListNode l1 = new LinkedListNode(10);
        LinkedListNode l2 = new LinkedListNode(20);
        LinkedListNode l3 = new LinkedListNode(30);
        LinkedListNode l4 = new LinkedListNode(40);
        LinkedListNode l5 = new LinkedListNode(50);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        LinkedListNode t2 = manipulateList(l1);

    }

    public LinkedListNode manipulateList(LinkedListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        LinkedListNode mid = getMid(root);
        LinkedListNode half = mid.next;
        mid.next = null;
        LinkedListNode cur1 = root, cur2 = half;
        while (cur1 != null) {
            LinkedListNode next1 = cur1.next, next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
        return root;

    }

    public LinkedListNode getMid(LinkedListNode root) {
        LinkedListNode slow = root, fast = root.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
