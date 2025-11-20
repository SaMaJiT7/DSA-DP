package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MODIFY_LIST {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        if(head == null){
            return null;
        }

        Set<Integer> set = new HashSet<>();
        for(int x: nums)set.add(x);


        while(head != null && set.contains(head.val)){
            head = head.next;
        }



        ListNode node = head;
        ListNode previous = dummy;

        while(node != null){
            if(set.contains(node.val)){
                previous.next = node.next;
            }
            node = node.next;

        }
        return dummy.next;
    }
}
