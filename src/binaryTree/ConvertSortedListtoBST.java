package binaryTree;

import org.junit.Test;

/**
 * Created by jiahan on 12/31/14.
 */
public class ConvertSortedListToBST {
    @Test
    public void sortedListToBST() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        TreeNode a = sortedListToBST(l1);
    }
    private ListNode list;
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode leftNode = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftNode;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, end);;
        return parent;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int n = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            n++;
        }
        list = head;
        return sortedListToBST(0, n - 1);
    }

    public TreeNode sortedListToBST2(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        ListNode mid = findMiddle(start, end);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(start, mid);
        root.right = sortedListToBST(mid.next, end);
        return root;
    }

    private ListNode findMiddle(ListNode start, ListNode end) {
        if (start == null || start.next == null) {
            return start;
        }
        ListNode fast = start;
        ListNode slow = start;
        while (fast.next != end && fast.next.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
