package HEAP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class findXSum {
//    public int[] findXSum(int[] nums, int k, int x) {
//        int n = nums.length;
//        int[] ans = new int[n-k+1];
//        int i = 0;
//        int j = 0;
//        while(j < n){
//            if(j-i+1 < k){
//                j++;
//            }
//            else if(j-i+1 == k){
//                // get the current window subarray
//                int[] new_arr = Arrays.copyOfRange(nums, i, j + 1);
//
//                // call your function with it
//                ans[i] = x_sum(new_arr, x);
//
//                // slide the window forward
//                i++;
//                j++;
//            }
//        }
//        return ans;
//    }
//    public int x_sum(int[] arr, int k){
//        PriorityQueue<Pair> Minheap = new PriorityQueue<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int sum = 0;
//
//        for(int nums : arr){
//            map.put(nums,map.getOrDefault(nums,0)+1);
//        }
//
//        for(int num :  map.keySet()){
//            Minheap.add(new Pair(num,map.get(num)));
//
//            if(Minheap.size() > k){
//                Minheap.poll();
//            }
//        }
//        while (Minheap.size() != 0){
//            Pair No = Minheap.poll();
//            sum += (No.freq * No.value);
//        }
//        return sum;
//    }
//
//    class Pair implements Comparable<Pair>{
//        int value;
//        int freq;
//
//        public Pair(int v,int f){
//            this.value = v;
//            this.freq = f;
//        }
//
//        @Override
//        public int compareTo(Pair o) {
//            // Compare by frequency first (ascending for min-heap)
//            int cmp = Integer.compare(this.freq, o.freq);
//            if (cmp != 0) return cmp;
//
//            // If frequencies are equal, compare by value (ascending)
//            return Integer.compare(this.value, o.value);
//        }
//    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n-k+1];
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i = 0; i < k; i++){
            int num = nums[i];
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        ans[0] = x_sum(freq, x);

        for(int i = k; i < n; i++){
            int out = nums[i-k];
            int in = nums[i];

            freq.put(out,freq.get(out)-1);
            if(freq.get(out) == 0) freq.remove(out);

            freq.put(in,freq.getOrDefault(in,0)+1);


            ans[i-k+1] = x_sum(freq,x);
        }
        return ans;
    }
    public long x_sum(HashMap<Integer,Integer> map, int k){
        PriorityQueue<Pair> Minheap = new PriorityQueue<>();

        long sum = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Minheap.add(new Pair(entry.getKey(),entry.getValue()));
            if(Minheap.size() > k){
                Minheap.poll();
            }
        }
        while (Minheap.size() != 0){
            Pair No = Minheap.poll();
            sum += (long) No.freq * No.value;
        }
        return sum;
    }

    class Pair implements Comparable<Pair>{
        int value;
        int freq;

        public Pair(int v,int f){
            this.value = v;
            this.freq = f;
        }

        @Override
        public int compareTo(Pair o) {
            // Compare by frequency first (ascending for min-heap)
            int cmp = Integer.compare(this.freq, o.freq);
            if (cmp != 0) return cmp;

            // If frequencies are equal, compare by value (ascending)
            return Integer.compare(this.value, o.value);
        }
    }
}
