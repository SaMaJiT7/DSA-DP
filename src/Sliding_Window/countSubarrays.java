package Sliding_Window;

public class countSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minKidx = -1;
        int maxKidx = -1;
        int bound = -1;
        long count = 0;
        for(int i = 0; i < n; i++){
            int val = nums[i];
            if(val < minK || val > maxK) bound = i;

            if(val == minK){
                minKidx = i;
            }
            if(val == maxK){
                maxKidx = i;
            }
            count += Math.min(maxKidx,minKidx) - bound;
        }
        return count;
    }
}
