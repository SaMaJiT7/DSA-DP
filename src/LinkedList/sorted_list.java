package LinkedList;

public class sorted_list {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return  null;
        }

        ListNode node = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(node != null){
            if(node.next != null && node.val == node.next.val){
                while(node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                prev.next = node.next;
            }
            else {
                prev = node;
            }
            node = node.next;
        }
        return dummy.next;
    }
}
