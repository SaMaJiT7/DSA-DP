package LinkedList;

import java.util.List;

public class ReOrderList {
    public void reorderList(ListNode head) {
       ListNode middle = head;
       ListNode fast = head;
       while(fast != null && fast.next != null){
           middle = middle.next;
           fast = fast.next.next;
       }
       ListNode nextMiddle = middle.next;
       middle.next = null;
       ListNode node = nextMiddle;
       ListNode prev = null;
       while(node != null) {
           ListNode next = node.next;
           node.next = prev;
           prev = node;
           node = next;
       }
       ListNode first = head;
       ListNode second = prev;

       while(second != null){
           ListNode next1 = first.next;
           ListNode next2 = second.next;
           first.next = second;
           second.next = next1;
           first = next1;
           second = next2;
       }
    }
}
