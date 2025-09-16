package LinkedList;

import java.util.ArrayList;

public class partition_list {
    public ListNode partition(ListNode head, int x) {
        ListNode lessNode = new ListNode();
        ListNode greaterequalNode = new ListNode();
        ListNode node= lessNode;
        ListNode remaining = greaterequalNode;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                lessNode.next = current;
                lessNode = current;
            }
            else {
                greaterequalNode.next = current;
                greaterequalNode = current;
            }
            current = current.next;
        }
        greaterequalNode.next = null;

        lessNode.next = remaining.next;

        return node.next;
    }
}
