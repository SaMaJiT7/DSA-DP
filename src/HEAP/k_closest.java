package HEAP;

import java.util.*;

public class k_closest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<pair> MaxHeap = new PriorityQueue<>();

        for(int num : arr){
            int key = Math.abs(num - x);
            int value = num;
            MaxHeap.add(new pair(key,value));

            if(MaxHeap.size() > k){
                MaxHeap.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (MaxHeap.size() != 0) {
            ans.add(MaxHeap.poll().value);  // Adds in ascending order (smallest of largest first)
        }
        Collections.sort(ans);
        return ans;
    }
    class pair implements Comparable<pair>{
        private int key;
        private int value;
        public pair(int key,int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(pair other) {
            // For max-heap: reverse for larger distances first, or tie-break by value
            if (this.key != other.key) {
                return Integer.compare(other.key,this.key);  // Max-heap on distance
            }
            return Integer.compare(other.value, this.value);  // Tie-break by larger value
        }
    }
}
