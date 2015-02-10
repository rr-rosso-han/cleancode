package linkedList;

/**
 * Created by jiahan on 2/10/15.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        ListNode newSecond = reverseList(second);
        mergeTwoLists(first, newSecond);
        return;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;


        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int i = 0;
        while (node1 != null && node2 != null) {
            if (i % 2 == 0) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
            i++;
        }
        if (node1 == null) {
            head.next = node2;
        }
        if (node2 == null) {
            head.next = node1;
        }
        return dummy.next;
    }
}
