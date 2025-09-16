package LinkedList;

public class linkedlist {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;

        ListNode secondhead = reverseList(mid);
        ListNode rereversed = secondhead;


        ListNode firstHalf = head;
        ListNode copySecond = secondhead; // To restore later if needed
        while (head != null && secondhead != null) {
            if (firstHalf.val != secondhead.val) {
                break;
            }
            firstHalf = firstHalf.next;
            secondhead = secondhead.next;
        }

        reverseList(rereversed);

        if(head == null || secondhead == null){
            return true;
        }
        return false;
        }

    private ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return head;
    }
}


