package LinkedList;

import java.util.List;

public class rotate_list {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        int len = 1;
        ListNode last = head;
        while(last.next != null){
            len++;
            last = last.next;
        }
        last.next = head;

        k = k % len;

        int steps = len-k-1;
        ListNode tail = head;
        ListNode prev = head;
        for(int i = 0; i <= steps; i++){
            prev = tail;
            tail = tail.next;
        }
        prev.next = null;
        head = tail;

        return head;
    }
}
