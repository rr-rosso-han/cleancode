package linkedList;

/**
 * Created by jiahan on 2/10/15.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
}
