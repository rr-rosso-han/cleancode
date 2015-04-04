package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 1/31/15.
 */
public class RemoveDuplicatesfromSortedList {
    @Test
    public void deleteDuplicates() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        a1.next = a2;

        ListNode b = deleteDuplicates(a1);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode next = head.next;
        while (current != null && next != null) {
            while (next != null && current.val == next.val) {
                next = next.next;
            }
            current.next = next;
            current = current.next;
            next = next.next;
        }
        return head;
    }
}
