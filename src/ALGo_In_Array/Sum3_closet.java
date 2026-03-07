package ALGo_In_Array;

import java.util.Arrays;

public class Sum3_closet {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            int closet = Integer.MAX_VALUE;
            int ans = 0;
            int left;
            int right;
            int sum = 0;
            for(int i = 0; i < n-2; i++){
                left = i+1;
                right = n-1;
                while(left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }

                    if(Math.abs(sum-target) < closet){
                        closet = Math.abs(sum-target);
                        ans = sum;
                    }
                }
            }
            return ans;
        }
}
