package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 1/31/15.
 */
public class RemoveDuplicatesfromSortedListII {
    @Test
    public void deleteDuplicates() {
        ListNode aa1 = new ListNode(1);
        ListNode aa2 = new ListNode(1);
        aa1.next = aa2;
        ListNode bb = deleteDuplicates(aa1);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode b = deleteDuplicates(a1);
        a1 = new ListNode(0);
        a2 = new ListNode(1);
        a1.next = a2;
        ListNode c = deleteDuplicates(a1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            boolean dup = false;
            while (current.next != null && current.val == current.next.val) {
                dup = true;
                current = current.next;
            }
            if (dup) {
                current = current.next;
                continue;
            }
            prev.next = current;
            prev = prev.next;
            current = current.next;
        }
        prev.next = current;
        return dummy.next;
    }

    public ListNode deleteDuplicatesII(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
