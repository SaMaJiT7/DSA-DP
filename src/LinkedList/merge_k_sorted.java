package LinkedList;

import java.util.List;
import java.util.PriorityQueue;

public class merge_k_sorted {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val,b.val));
        int n = lists.length;
        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);
            }
        }

        if(minHeap.isEmpty()){
            return null;
        }

        ListNode head = minHeap.poll();

        if(head.next != null){
            minHeap.add(head.next);
        }

        ListNode tail = head;

        while(!minHeap.isEmpty()){
            ListNode curr = minHeap.poll();
            tail.next = curr;
            tail = tail.next;
            if(curr.next != null) {
                minHeap.add(curr.next);
            }
        }
        return head;
    }
}
