package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 2/10/15.
 */
public class LinkedListCycleII {

    @Test
    public void test() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        a2.next = a1;
        ListNode c = detectCycle(a1);
        return;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head == head.next) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                if (fast == head) {
                    return head;
                } else {
                    fast = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return slow;
                }
            }
        }
        return null;
    }
}
