package HEAP;

import java.util.*;

public class k_smallest_pairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return answer;
        PriorityQueue<Pair> minheap = new PriorityQueue<>();
        minheap.add(new Pair(0,0,nums1[0]+nums2[0]));
        HashSet<String> unique = new HashSet<>();
        unique.add(0+"#"+0);
        while(k-- > 0 && !minheap.isEmpty()){
            List<Integer> value = new ArrayList<>();
            Pair p = minheap.poll();
            int i = p.i;
            int j = p.j;
            value.add(nums1[i]);
            value.add(nums2[j]);
            if(i+1 < nums1.length){
                String present = (i + 1) + "#" + j;
                if(!unique.contains(present)) {
                    minheap.add(new Pair(i + 1, j, nums1[i + 1] + nums2[j]));
                    unique.add(present);
                }
            }
            if(j+1 < nums2.length){
                String present = i + "#" + (j+1);
                if(!unique.contains(present)) {
                    minheap.add(new Pair(i,j+1,nums1[i]+nums2[j+1]));
                    unique.add(present);
                }
            }
            answer.add(value);
        }
        return answer;
    }

    class Pair implements Comparable<Pair>{
        int i;
        int j;
        int sum;


        public Pair(int x, int y,int sum){
            this.i = x;
            this.j = y;
            this.sum = sum;
        }


        @Override
        public int compareTo(Pair o) {
            if(this.sum == o.sum){
                if(this.i == o.i){
                    return Integer.compare(this.j,o.j);
                }
                return Integer.compare(this.i,o.i);
            }
            return Integer.compare(this.sum,o.sum);
        }
    }
}
