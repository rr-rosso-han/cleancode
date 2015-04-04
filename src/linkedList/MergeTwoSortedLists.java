package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 12/22/14.
 */
public class MergeTwoSortedLists {

    @Test
    public void mergeTwoLists() {
        ListNode a = new ListNode(-10);
        ListNode a1 = new ListNode(-9);
        ListNode a2 = new ListNode(-6);
        ListNode a3 = new ListNode(-4);
        ListNode a4 = new ListNode(1);
        ListNode a5 = new ListNode(9);
        ListNode a6 = new ListNode(9);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        ListNode b = new ListNode(-5);
        ListNode b1 = new ListNode(-3);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(7);
        ListNode b4 = new ListNode(8);
        ListNode b5 = new ListNode(8);
        b.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode c = mergeTwoLists(a, b);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return dummy.next;
    }
}
