//import LinkedList.ListNode;
//
//public class kreversed {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(k <= 1 || head == null){
//            return head;
//        }
//        ListNode node = head;
//        ListNode prev = null;
//        while(true) {
//            ListNode last = prev;
//            ListNode newend = node;
//
//            ListNode nextNode = node.next;
//            for (int i = 0; node != null && i < k; i++) {
//                node.next = prev;
//                prev = node;
//                node = nextNode;
//                if(nextNode != null){
//                    nextNode = nextNode.next;
//                }
//            }
//            if(last != null){
//                last.next =prev;
//            }else{
//                head = prev;
//            }
//            newend.next = node;
//            if(node == null){
//                break;
//            }
//            prev = newend;
//        }
//        return head;
//    }
//
//    private ListNode reverseList(ListNode head) {
//        ListNode node = head;
//        ListNode prev = null;
//        while (node != null) {
//            ListNode nextNode = node.next;
//            node.next = prev;
//            prev = node;
//            node = nextNode;
//        }
//        return head;
//    }
//}
