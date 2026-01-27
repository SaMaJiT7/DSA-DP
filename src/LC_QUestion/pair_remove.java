package LC_QUestion;

import HEAP.k_closest;

import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class pair_remove {
    public int minimumPairRemoval(int[] arr) {
        int n = arr.length;
        if(isNonDecreasing(arr)){
            return 0;
        }
        long[] nums = new long[n];
        int operations = 0;
        int badpair = 0;
        int[] previndex = new int[n];
        int[] nextindex = new int[n];
        for(int i = 0; i < n; i++){
            previndex[i] = i-1;
            nextindex[i] = i+1;
            nums[i] = arr[i];
        }
        TreeSet<Pair> MinTree = new TreeSet<>();
        for(int i = 0; i < n-1; i++){
            long sum = nums[i] + nums[i+1];
            MinTree.add(new Pair(sum,i));
            if(nums[i] > nums[i+1]){
                badpair++;
            }
        }

        while(badpair != 0 && !MinTree.isEmpty()) {
            Pair MinPair = MinTree.pollFirst();
            int first = MinPair.idx;
            int second = nextindex[first];

            int first_left = previndex[first];
            int second_right = nextindex[second];

            long newsum = nums[first] + nums[second];
            if(nums[first] > nums[second]){
                badpair--;
            }
            if(first_left >= 0) {
                if (nums[first_left] > nums[first]
                        && nums[first_left] <= (nums[first] + nums[second])) {
                    badpair--;
                } else if (nums[first_left] <= nums[first]
                        && nums[first_left] > (nums[first] + nums[second])) {
                    badpair++;
                }
                MinTree.remove(new Pair(nums[first_left] + nums[first], first_left));
                MinTree.add(new Pair(nums[first_left] + newsum, first_left));
            }
            if(second_right < n) {
                if (nums[second_right] >= nums[second]
                        && nums[second_right] < (nums[first] + nums[second])) {
                    badpair++;
                } else if (nums[second_right] < nums[second] && nums[second_right] >= (nums[first] + nums[second])) {
                    badpair--;
                }
                MinTree.remove(new Pair(nums[second] + nums[second_right], second));
                MinTree.add(new Pair(newsum+nums[second_right], first));
                previndex[second_right] = first;
            }

            nextindex[first] = second_right;
            nums[first] = nums[first] + nums[second];
            operations++;
        }
        return operations;
    }
    public boolean isNonDecreasing(int[] list){
        if(list.length <= 1) return true;
        for(int i = 1; i < list.length; i++){
            if(list[i-1] > list[i]){
                return false;
            }
        }
        return true;
    }
    class Pair implements Comparable<Pair>{
        private long sum;
        private int idx;

        public Pair(long sum, int index){
            this.sum = sum;
            this.idx = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.sum != other.sum) {
                return Long.compare(this.sum,other.sum);  // Max-heap on distance
            }
            return Integer.compare(this.idx,other.idx);  // Tie-break by larger value
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            // Two pairs are equal if they have the same sum AND same index
            return sum == pair.sum && idx == pair.idx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, idx);
        }
    }
}
