package amazon;

/**
 * Created by jiahan on 12/27/14.
 */
public class ListManipulation {
    static LinkedListNode manipulateList(LinkedListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        LinkedListNode mid = getMid(root);
        LinkedListNode half = mid.next;
        mid.next = null;
        LinkedListNode cur1 = root, cur2 = half;
        while (cur1 != null) {
            LinkedListNode next1 = cur1.next, next2 = cur2.next;
            cur1.next = cur2;
            //if next1 == null, cur2.next will not be changed.
            if (next1 != null) {
                cur2.next = next1;
            }
            cur1 = next1;
            cur2 = next2;
        }
        return root;

    }

    static LinkedListNode getMid(LinkedListNode root) {
        LinkedListNode slow = root, fast = root.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
