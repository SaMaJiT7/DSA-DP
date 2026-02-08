package Sliding_Window;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class leetcode_3013_hard {
        public long minimumCost(int[] nums, int k, int dist) {
            int n = nums.length;
            TreeSet<Pair> kmin = new TreeSet<>((a, b) -> {
                if (a.val != b.val) return Integer.compare(a.val, b.val);
                return Integer.compare(a.index, b.index);
            });

            // remain: MinHeap. Keeps track of everything else.
            TreeSet<Pair> remain =  new TreeSet<>((a, b) -> {
                if (a.val != b.val) return Integer.compare(a.val, b.val);
                return Integer.compare(a.index, b.index);
            });
            long sum = 0;
            long result = Long.MAX_VALUE;
            for (int i = 1; i < n; i++) {

                kmin.add(new Pair(nums[i], i));
                sum += nums[i];


                if (kmin.size() > k - 1) {
                    Pair p = kmin.pollLast(); // Remove the largest of the "small" candidates
                    sum -= p.val;
                    remain.add(p);
                }


                if (i > dist + 1) {
                    int targetIndex = i - dist - 1;
                    Pair removePair = new Pair(nums[targetIndex], targetIndex);

                    if (kmin.contains(removePair)) {
                        kmin.remove(removePair);
                        sum -= removePair.val;


                        if (!remain.isEmpty()) {
                            Pair addE = remain.pollFirst(); // Get smallest from reserve
                            kmin.add(addE);
                            sum += addE.val;
                        }
                    } else {
                        remain.remove(removePair);
                    }
                }


                if (kmin.size() == k - 1) {
                    result = Math.min(result, sum);
                }
            }
        return nums[0] + result;
}
        class Pair{
            int val;
            int index;


            public Pair(int element,int idx){
                this.val = element;
                this.index = idx;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                // Unique identification by index is usually sufficient for this problem
                return index == pair.index && val == pair.val;
            }

            @Override
            public int hashCode() {
                return Objects.hash(val, index);
            }

        }
}
