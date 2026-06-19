package LinkedList;

import java.util.List;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode curr = node;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            int n;
            if(sum >= 10){
                n = sum % 10;
                carry = sum / 10;
            }
            else{
                n = sum;
                carry = 0;
            }
            ListNode node1 = new ListNode(n);
            curr.next = node1;
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return node.next;
    }
}
