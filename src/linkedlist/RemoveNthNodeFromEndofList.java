package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 1/20/15.
 */
public class RemoveNthNodeFromEndofList {

    @Test
    public void removeNthFromEnd() {
        ListNode a = new ListNode(1);
        int n = 1;
        ListNode b = removeNthFromEnd(a, n);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = dummy;
        int i = 0;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        if (i != n) {
            return dummy.next;
        }
        while (slow != null && fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return dummy.next;
    }
}
