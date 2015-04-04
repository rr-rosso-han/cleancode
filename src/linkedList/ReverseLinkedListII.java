package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 2/10/15.
 */
public class ReverseLinkedListII {

    @Test
    public void test() {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(5);

        a1.next = a2;
        ListNode r = reverseBetween(a1, 1, 1);
        return;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        for (int i = 1; i < m; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        ListNode beforeMNode = current;
        ListNode mNode = current.next;
        ListNode nNode = mNode, afterNNode = mNode.next;

        for (int i = m; i < n; i++) {
            if (afterNNode == null) {
                return null;
            }
            ListNode temp = afterNNode.next;
            afterNNode.next = nNode;
            nNode = afterNNode;
            afterNNode = temp;
        }
        mNode.next = afterNNode;
        beforeMNode.next = nNode;

        return dummy.next;
    }
}
