package LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class k_sorted_merge {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int n = lists.length;
        for(ListNode val : lists){
            if(val != null)
                pq.add(val);
        }
        if(pq.isEmpty()) return null;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                pq.add(node);
            }
        }
        return head.next;
    }
}
