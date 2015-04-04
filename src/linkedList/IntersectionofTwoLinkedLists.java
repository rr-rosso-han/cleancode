package linkedList;

/**
 * Created by jiahan on 2/13/15.
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a1 = headA;
        ListNode a2 = headB;
        int lenA = 0;
        int lenB = 0;
        while (a1 != null) {
            a1 = a1.next;
            lenA++;
        }

        while (a2 != null) {
            a2 = a2.next;
            lenB++;
        }
        int gap = lenA - lenB;
        boolean flag = false;
        if (gap < 0) {
            gap = Math.abs(gap);
            flag = true;
        }
        a1 = headA;
        a2 = headB;
        for (int i = 0; i < gap; i++) {
            if (flag) {
                a2 = a2.next;
            } else {
                a1 = a1.next;
            }
        }

        while (a1 != null && a2 != null) {
            if (a1 == a2) {
                return a1;
            } else {
                a1 = a1.next;
                a2 = a2.next;
            }
        }
        return null;
    }
}
