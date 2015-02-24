package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 2/21/15.
 */
public class ReverseNodesinkGroup {

    @Test
    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode b = reverseKGroup(a1, 4);
        return;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            count++;
            ListNode next = current.next;

            if (count == k) {
                prev = reverse(prev, next);
                count = 0;
            }

            current = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode prev, ListNode end) {
        if (prev == null || prev.next == null) {
            return prev;
        }
        ListNode head = prev.next;
        ListNode cur = head.next;

        while (cur != end) {
            ListNode tmp = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = tmp;
        }
        head.next = end;
        return head;
    }
}
