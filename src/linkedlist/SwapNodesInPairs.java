package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 12/22/14.
 */
public class SwapNodesInPairs {

    @Test
    public void swapPairs() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode r = swapPairs(l1);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;
        ListNode tmp;
        ListNode next;
        while (current != null && current.next != null) {
            tmp = current.next.next;
            next = current.next;
            prev.next = next;
            next.next = current;
            current.next = tmp;
            prev = current;
            current = tmp;
        }
        return dummy.next;
    }
}
