package HEAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ksmallest_pairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> MinHeap = new PriorityQueue<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

       for(int i = 0; i < Math.min(nums1.length,k); i++){
           List<Integer> val = Arrays.asList(nums1[i],nums2[0]);
           MinHeap.add(new Pair(nums1[i]+nums2[0],val,i,0));
       }

       while(k-- > 0 && !MinHeap.isEmpty()){
           Pair curr = MinHeap.poll();
           ans.add(curr.value);


           int i = curr.i;
           int j = curr.j;

           // Move right in nums2
           if (j + 1 < nums2.length) {
               List<Integer> nextVal = Arrays.asList(nums1[i], nums2[j + 1]);
               MinHeap.offer(new Pair(nums1[i] + nums2[j + 1], nextVal, i, j + 1));
           }
       }
       return ans;
    }

    class Pair implements Comparable<Pair>{
        int sum;

        List<Integer> value;

        int i, j; // indices in nums1 and nums2

        public Pair(int sum,List<Integer> value,int i, int j){
            this.sum = sum;
            this.value = value;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair other) {
            // First, compare by sum (descending order)
            int cmp = Integer.compare(this.sum, other.sum);
            if (cmp != 0) return cmp;

            // If sums are equal, compare lexicographically by list elements
            for (int i = 0; i < Math.min(this.value.size(), other.value.size()); i++) {
                int c = Integer.compare(this.value.get(i), other.value.get(i));
                if (c != 0) return c;
            }

            // If all elements equal till now, shorter list comes first
            return Integer.compare(this.value.size(), other.value.size());
        }
    }
}
