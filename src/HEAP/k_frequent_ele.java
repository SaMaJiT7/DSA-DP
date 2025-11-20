package HEAP;

import java.util.*;

public class k_frequent_ele {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> Minheap = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Minheap.add(new Pair(entry.getValue(),entry.getKey()));
            if(Minheap.size() > k){
                Minheap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (Minheap.size() != 0) {
            ans.add(Minheap.poll().value);  // Adds in ascending order (smallest of largest first)
        }

        return ans.stream().mapToInt(i->i).toArray();

    }
    class Pair implements Comparable<Pair>{
        private int freq;
        private int value;


        public  Pair(int freq,int value){
            this.freq = freq;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.freq != other.freq) {
                return Integer.compare(this.freq, other.freq); // min-heap on frequency
            }
            return Integer.compare(this.value, other.value);       // tie-break on value
        }
    }
}
