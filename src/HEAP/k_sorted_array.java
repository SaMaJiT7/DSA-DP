package HEAP;

import java.util.PriorityQueue;

public class k_sorted_array {
    public void nearlySorted(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int index = 0;
        for(int i = 0; i < n ; i++){
            minheap.add(arr[i]);

            if(minheap.size() > k){
                arr[index++] = minheap.poll();
            }

            while (!minheap.isEmpty()) {
                arr[index++] = minheap.poll();
            }
        }

    }
}
