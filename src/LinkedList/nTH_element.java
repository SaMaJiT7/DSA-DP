package LinkedList;


public class nTH_element {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode current = head;
        int index = 0;
        int length = 0;

        while(current != null){
            length = length + 1;
            current = current.next;
        }

        int m = length - n;
        if (m < 0 || m >= length) {
            return head;
        }


        if (m == 0) {
            return head.next;
        }

        ListNode previous = null;
        while(node != null){
            if(index == m){
                previous.next = node.next;
            }
            previous = node;
            node = node.next;
            index++;
        }
        return head;
    }
}
