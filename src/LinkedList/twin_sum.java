package LinkedList;

import java.util.ArrayList;

public class twin_sum {
//    public int pairSum(ListNode head) {
//        ListNode middle = head;
//        ListNode tail = head;
//        while(tail != null && tail.next != null){
//            middle = middle.next;
//            tail = tail.next.next;
//        }
//        ListNode node = head;
//        ListNode node2 = reverse(middle);
//
//        int max = Integer.MIN_VALUE;
//
//        while(node2 != null){
//            int v1 = node.val;
//            int v2 = node2.val;
//            max = Math.max(max,v1+v2);
//            node = node.next;
//            node2 = node2.next;
//        }
//
//        return max;
//    }
//
//    public ListNode reverse(ListNode head){
//        ListNode node = head;
//        ListNode prev = null;
//        while(node != null){
//            ListNode nextNode = node.next;
//            node.next = prev;
//            prev = node;
//            node = nextNode;
//        }
//
//        return prev;
//    }
    public int pairSum(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            nums.add(node.val);
            node = node.next;
        }
        int n = nums.size();
        int max = 0;
        for(int i = 0 ; i < n; i++){
            int v1 = nums.get(i);
            int v2 = nums.get(n-1-i);
            max = Math.max(max,v1+v2);
        }

        return max;
    }
}
