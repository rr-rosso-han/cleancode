package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 2/9/15.
 */
public class SortList {

    @Test
    public void test() {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        a.next = b;
        ListNode c = sortList(a);
        return;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = mergeSort(head);
        return node;
    }

    private ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode first = node;
        ListNode mid = getMiddle(node);
        ListNode second = mid.next;
        mid.next = null;

        ListNode newFirst = mergeSort(first);
        ListNode newSecond = mergeSort(second);
        return mergeTwoLists(newFirst, newSecond);
    }

    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        if (node1 == null) {
            head.next = node2;
        }
        if (node2 == null) {
            head.next = node1;
        }
        return dummy.next;
    }

    private ListNode getMiddle(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode fast = node.next;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
