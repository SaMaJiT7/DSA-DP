package LC_QUestion;

import java.util.PriorityQueue;

public class kth_largest {
    PriorityQueue<Integer> pq;
    int k;
    public kth_largest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            pq.add(nums[i]);

            while(pq.size() > k){
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        while(pq.size() > k){
            pq.poll();
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
    }
}
