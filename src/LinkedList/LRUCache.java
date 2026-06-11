package LinkedList;

import java.util.HashMap;
import java.util.LinkedList;
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    HashMap<Integer,Node> map;
    int capacity;
    Node dummyHead;
    Node dummyTail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.dummyHead = new Node(-1,-1);
        this.dummyTail = new Node(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;

    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        //get the node
        Node node = map.get(key);

        // delete the node and connect its previous and next together
        deleteNode(node);

        // adding the deleted node at the tail node as most recently used.
        addNode(node);

        return node.value;

        }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;


            deleteNode(node);

            addNode(node);
        }
        else{
            if(map.size() == capacity){
                Node lru = dummyHead.next;

                map.remove(lru.key);
                deleteNode(lru);
            }

            Node node = new Node(key,value);
            addNode(node);

            map.put(key,node);
        }
    }

    public void addNode(Node node){
        Node last = dummyTail.prev;

        last.next = node;
        node.prev = last;

        node.next = dummyTail;
        dummyTail.prev = node;
    }

    public void deleteNode(Node node){
        Node nodeprev = node.prev;
        Node nodenext = node.next;

        nodeprev.next = nodenext;
        nodenext.prev = nodeprev;
    }

}
