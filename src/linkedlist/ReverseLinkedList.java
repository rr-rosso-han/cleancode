package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 1/27/15.
 */
public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode pre = null;
        ListNode next = null;

        while (current != null) {
            //record second node
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    @Test
    public void reverseRecursive() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b = reverseRecursive(a1);
    }

    public ListNode reverseRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
