package linkedList;

import org.junit.Test;

import java.util.List;

/**
 * Created by jiahan on 2/13/15.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy;
        while (head != null) {
            if (prev.next != null && prev.next.val <= head.val) {
                prev = prev.next;
            }
            ListNode tmp = head.next;
            head.next = prev.next;
            prev.next = head;
            head = tmp;
        }
        return dummy.next;


    }
    @Test
    public void test() {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        ListNode b = insertionSortList(a1);
        return;
    }
    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode next = null;

        while (head != null) {
            if (prev.next == null) {
                next = head.next;
                head.next = prev.next;
                prev.next = head;
                head = next;
            } else {
                if (prev.next.val > head.val) {
                    next = head.next;
                    head.next = prev.next;
                    prev.next = head;
                    head = next;
                } else {
                    prev = prev.next;
                }
            }
        }
        return dummy.next;
    }
}
