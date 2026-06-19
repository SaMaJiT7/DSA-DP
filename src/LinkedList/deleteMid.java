package LinkedList;

import java.util.List;

public class deleteMid {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }

        ListNode middle = head;
        ListNode prev = null;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = middle;
            middle = middle.next;
            fast = fast.next.next;
        }
        ListNode next = middle.next;

        if(middle.val > prev.val && middle.val > next.val){
            prev.next = next;
        }

        return head;
    }
}
