

public class reorder {
//    public class ListNode {
//        int val;
//        LinkedList.ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, LinkedList.ListNode next) { this.val = val; this.next = next; }
//    }
//    public void reorderList(ListNode head) {
//
//        if(head == null || head.next == null){
//            return;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode mid = slow;
//
//        ListNode hs = reverseList(mid);
//        ListNode hf = head;
//
//while(hf != null && hs != null) {
//    ListNode temp = hf.next;
//    hf.next = hs;
//    hf = temp;
//
//    temp = hs.next;
//    hs.next = hf;
//    hs = temp;
//}
//if (hf != null){
//    hf.next = null;
//}
//    }
//    private ListNode reverseList(ListNode head) {
//        ListNode node = head;
//        ListNode prev = null;
//        while (node != null) {
//            ListNode nextNode = node.next;
//            node.next = prev;
//            prev = node;
//            node = nextNode;
//        }
//        return prev;
//    }
}
