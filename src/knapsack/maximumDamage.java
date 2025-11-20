package knapsack;

import java.util.*;

public class maximumDamage {
//    public long maximumTotalDamage(int[] power) {
//        HashMap<Long,Long> map = new HashMap<>();
//        for(int i : power){
//            map.put((long) i,map.getOrDefault((long) i, 0l)+1);
//        }
//
//        // store unique sorted keys
//        ArrayList<Long> nums = new ArrayList<>(map.keySet());
//        Collections.sort(nums);
//
//        long[] memo = new long[nums.size()];
//        Arrays.fill(memo, -1);
//
//        return helper(nums, map, 0, memo);
//    }
//
//    public long helper(ArrayList<Long> nums, HashMap<Long, Long> map, int i, long[] memo) {
//        int n = nums.size();
//
//        if (i >= n) return 0;
//        if (memo[i] != -1) return memo[i];
//
//        // skip current
//        long skip = helper(nums, map, i + 1, memo);
//
//        // find next index where num >= nums[i] + 3
//        long nextVal = nums.get(i) + 3;
//        int j = Collections.binarySearch(nums, nextVal);
//        if (j < 0) j = -j - 1; // insertion point
//
//        // take current: (value * freq) + next valid
//        long take = nums.get(i) * map.get(nums.get(i)) + helper(nums, map, j, memo);
//
//        memo[i] = Math.max(skip, take);
//        return memo[i];
//    }


    public long maximumTotalDamage(int[] power) {
        HashMap<Long,Long> map = new HashMap<>();
        for(int i : power){
            map.put((long) i,map.getOrDefault((long) i, 0l)+1);
        }

        // store unique sorted keys
        ArrayList<Long> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums);
        int n = nums.size();
        long[] t = new long[n];
        Arrays.fill(t,0);

        long result = Integer.MIN_VALUE;

        for(int i = n-1; i >= 0; i--) {
            // skip current
            long skip = (i+1 < n) ? t[i + 1] : 0;

            // find next index where num >= nums[i] + 3
            long nextVal = nums.get(i) + 3;
            int j = Collections.binarySearch(nums, nextVal);
            if (j < 0) j = -j - 1; // insertion point

            // take current: (value * freq) + next valid
            long take = 0;
            if(j < n) {
                 take = nums.get(i) * map.get(nums.get(i)) + t[j] ;
            }
            else {
                take = nums.get(i) * map.get(nums.get(i));
            }


            t[i] = Math.max(skip, take);

            result = Math.max(result, t[i]);
        }
        return result;
    }

}
