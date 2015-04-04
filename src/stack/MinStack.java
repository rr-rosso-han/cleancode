package stack;

import java.util.Stack;

/**
 * Created by jiahan on 1/6/15.
 */
public class MinStack {

    private Node first;
    private Stack<Integer> minStack = new Stack<Integer>();
    private int N;

    class Node {
        int val;
        Node next;
        Node(int v) {
            this.val = v;
        }
    }

    public void push(int x) {
        Node oldFirst = first;
        Node node = new Node(x);
        first = node;
        first.next = oldFirst;
        N++;

        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (first != null) {
            first = first.next;
            N--;
            minStack.pop();
        } else {
            throw new IllegalAccessError("Stack is empty");
        }
    }

    public int top() {
        if (first != null) {
            return first.val;
        } else {
            throw new IllegalAccessError("Stack is empty");
        }
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            throw new IllegalAccessError("Stack is empty");
        }
    }
}
