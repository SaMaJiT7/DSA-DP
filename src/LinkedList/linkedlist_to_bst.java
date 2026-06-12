package LinkedList;

import DP_Tree.TreeNode;

import java.util.List;

public class linkedlist_to_bst {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode start = head;
        ListNode end = head;

        return buildTree(start,null);
    }
    public TreeNode buildTree(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode mid = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode Node = new TreeNode(mid.val);

        Node.left = buildTree(head,mid);
        Node.right = buildTree(mid.next,tail);

        return Node;
    }
}
