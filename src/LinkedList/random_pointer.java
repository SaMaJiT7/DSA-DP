package LinkedList;

import java.util.HashMap;

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class random_pointer {
    public Node1 copyRandomList(Node1 head) {
        HashMap<Node1,Node1> map = new HashMap<>();
        Node1 curr = head;
        while(curr != null){
            map.put(curr,new Node1(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node1 copy = map.get(curr);
            Node1 next = curr.next;
            Node1 nextRandom = curr.random;
            copy.next = map.get(next);
            copy.random = map.get(nextRandom);
            curr = curr.next;
        }

        return map.get(head);
    }
}
