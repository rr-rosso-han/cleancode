package linkedList;

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
}
