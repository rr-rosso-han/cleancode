package linkedlist;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by jiahan on 12/23/14.
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new java.util.Comparator<ListNode>() {
            @Override
            public int compare(ListNode x, ListNode y) {
                return x.val - y.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }
    /*
    * O(nklogn) time
    * use O(1) space
    * */
    public ListNode mergeKListsO1(List<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        int end = lists.size() - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists.set(begin, mergeTwoLists(lists.get(begin), lists.get(end)));
                begin++;
                end--;
            }
        }
        return lists.get(0);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return dummy.next;
    }
}
