package Greedy;

import java.util.Arrays;

public class minimize_maximum_pair {
//    public int minPairSum(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        if(n % 2 != 0){
//            return 0;
//        }
//        int maxpairsum = 0;
//        int i = 0;
//        int j = n-1;
//        while(i < j){
//            int sum = nums[i]+nums[j];
//
//            maxpairsum = Math.max(maxpairsum,sum);
//
//            i++;
//            j--;
//        }
//        return maxpairsum;
//    }
public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    if(n % 2 != 0){
        return 0;
    }
    int MIN = Integer.MAX_VALUE;
    int MAX = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
        MIN = Math.min(MIN,nums[i]);
        MAX = Math.max(MAX,nums[i]);
    }
    int maxpairsum = MIN+MAX;
    return maxpairsum;
}
}
