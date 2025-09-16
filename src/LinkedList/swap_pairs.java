package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class swap_pairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return head;
    }
    public ListNode oddEvenList(ListNode head) {
        ListNode oddlist = new ListNode(0);
        ListNode evenlist = new ListNode(0);
        ListNode odd = oddlist;
        ListNode even = evenlist;

        ListNode node = head;

        int i = 0;
        while(node != null){
            if(i % 2 == 0){
                odd.next = node;
                odd = node;
            }
            else{
                even.next = node;
                even = node;
            }
            i++;
            node = node.next;
        }

        odd.next = evenlist.next;
        even.next = null;


        return oddlist.next;
    }

}
