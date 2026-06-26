package LinkedList;

import java.util.List;

public class Reverse_K_nodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        ListNode prev = null;
        int count = 0;
        while(node != null && count < k){
            prev = node;
            node = node.next;
            count++;
        }
        if(count < k) return head;

        ListNode kthnode = prev;
        ListNode nextGroup = node;

        kthnode.next = null;

        ListNode newHead = reverse(head);
        head.next = reverseKGroup(nextGroup,k);
        return newHead;
    }
    public ListNode reverse(ListNode head){
        ListNode node = head;
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
