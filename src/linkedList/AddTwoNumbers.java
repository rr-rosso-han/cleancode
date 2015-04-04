package linkedList;

/**
 * Created by jiahan on 12/22/14.
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carrier = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int num = 0;
        while (l1 != null && l2 != null) {
            if (l1.val + l2.val >= 10) {
                num = carrier + l1.val + l2.val - 10;
                carrier = 1;
            } else {
                num = carrier + l1.val + l2.val;
                carrier = 0;
            }
            ListNode node = new ListNode(num);
            head.next = node;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                num = l2.val + carrier;
                if (num >= 10) {
                    num = num - 10;
                    carrier = 1;
                } else {
                    carrier = 0;
                }
                ListNode node = new ListNode(num);
                l2 = l2.next;
                head.next = node;
                head = head.next;
            }
        }

        if (l2 == null) {
            while (l1 != null) {
                num = l1.val + carrier;
                if (num >= 10) {
                    num = num - 10;
                    carrier = 1;
                } else {
                    carrier = 0;
                }
                ListNode node = new ListNode(num);
                l1 = l1.next;
                head.next = node;
                head = head.next;
            }
        }
        if (carrier > 0) {
            ListNode node = new ListNode(1);
            head.next = node;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carrier = 0;
        int num = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            if (carrier + x + y >= 10) {
                num = carrier + x + y - 10;
                carrier = 1;
            } else {
                num = carrier + x + y;
                carrier = 0;
            }
            ListNode node = new ListNode(num);
            head.next = node;
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
