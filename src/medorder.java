//public class medorder {
//    public ListNode rotateRight(ListNode head, int k) {
//        if(k == 0 ||head == null || head.next == null ){
//            return head;
//        }
//        ListNode current = head;
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode prev = null;
//        int length = 1;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            length++;
//        }
//
//        ListNode last = fast;
//
//        //connecting with head
//        last.next = head;
//        int rotations = k % length;
//        int skip = length - rotations;
//        ListNode newlast = head;
//        for (int i = 0; i <  skip - 1; i++) {
//            newlast = newlast.next;
//        }
//        head = newlast.next;
//        newlast.next = null;
//        return head;
//    }
//}
