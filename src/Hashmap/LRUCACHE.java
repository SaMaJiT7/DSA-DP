package Hashmap;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCACHE {
//    LinkedList<Pair> list;
//    HashMap<Integer,Pair> map;
//    Pair head,tail;
//    int capacity;
//        public LRUCACHE(int capacity) {
//            this.map = new HashMap<>(capacity);
//            this.list = new LinkedList<Pair>();
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            if(map.containsKey(key)){
//               Pair node =  map.get(key);
//               list.remove(node);
//               list.addLast(node);
//               return node.val;
//            }
//            else{
//                return -1;
//            }
//        }
//
//        public void put(int key, int value) {
//            if(map.containsKey(key)){
//                Pair node = map.get(key);
//                node.val = value;
//                list.remove(node);
//                list.addLast(node);
//            }
//            else{
//               if(map.size() == capacity){
//                   Pair lru = list.getFirst();
//                   list.removeFirst();
//                   map.remove(lru.key);
//               }
//               Pair p = new Pair(key,value);
//               list.addLast(p);
//               map.put(key,p);
//            }
//
//
//        }
//        class Pair{
//            int key;
//            int val;
//            Pair next;
//            Pair prev;
//            public Pair(int key,int val){
//                this.key = key;
//                this.val = val;
//            }
//    }
}
