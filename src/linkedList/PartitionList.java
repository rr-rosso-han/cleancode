package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 2/1/15.
 */
public class PartitionList {

    @Test
    public void partition() {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(4);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(2);
        ListNode t5 = new ListNode(5);
        ListNode t6 = new ListNode(2);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;

        ListNode t7 = new ListNode(2);
        ListNode t8 = new ListNode(1);
        t7.next = t8;
        ListNode b1 = partition(t7, 1);

        ListNode b = partition(t1, 3);
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode mid = new ListNode(0);
        ListNode second = mid;

        while (head != null) {
            if (x > head.val) {
                first.next = head;
                first = first.next;
            } else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        second.next = null;
        first.next = mid.next;
        return dummy.next;
    }
}
