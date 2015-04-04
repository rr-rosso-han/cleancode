package linkedList;

import org.junit.Test;

/**
 * Created by jiahan on 2/10/15.
 */
public class RotateList {

    @Test
    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;

        ListNode c = rotateRight(a1, 2);
        return;
    }
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }
        ListNode current = head;
        ListNode last = null;
        int size = 0;
        while(current != null) {
            last = current;
            current = current.next;
            size++;
        }
        if (size < n) {
            n = n % size;
        }
        int len = size - n;
        if (len == size || len == 0) {
            return head;
        }
        current = head;
        ListNode prev = null;
        for (int i = 0; i < len; i++) {
            prev = current;
            current = current.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        last.next = head;
        return current;
    }

    public ListNode rotateRight2(ListNode head, int n) {
        if(head==null){
            return null;
        }
        int num = 0;
        ListNode node = head;
        ListNode tail = head;
        while(node!=null){
            tail = node;
            node=node.next;
            num++;
        }
        n=num-n%num-1;
        ListNode newHead=head;
        ListNode pre = null;
        while(newHead!=null&&n>=0){
            pre=newHead;
            newHead=newHead.next;
            n--;
        }
        if(newHead!=null){
            if(newHead==head){
                return head;
            }else{
                pre.next=null;
                tail.next=head;
                return newHead;
            }
        }
        return head;
    }

}
