package Leetcode_daily;

import java.util.*;

public class subseqeuence_k_length {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> MinHeap =
                new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < n; i++){
            MinHeap.add(new int[]{nums[i],i});

            while(MinHeap.size() > k){
                MinHeap.poll();
            }
        }
        List<int[]> ans = new ArrayList<>();
        while (!MinHeap.isEmpty()){
            ans.add(MinHeap.poll());
        }
        Collections.sort(ans,(a,b) -> Integer.compare(a[1],b[1]));

        return  ans.stream().mapToInt(a -> a[0]).toArray();
    }
}
