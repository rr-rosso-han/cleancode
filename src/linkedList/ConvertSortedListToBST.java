package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 2/21/15.
 */
public class ConvertSortedListToBST {
    private class TreeNode<E> {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class ResultWrapper {
        TreeNode node;
        ListNode current;
        ResultWrapper() {}
        ResultWrapper(TreeNode x, ListNode y) {
            node = x;
            current = y;
        }
    }
    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    @Test
    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        a1.next = a2;
        TreeNode b = sortedListToBST(a1);
        return;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;
        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
}
