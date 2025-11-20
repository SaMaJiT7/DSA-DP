package LC_QUestion;

import java.util.ArrayList;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] t = {-1,-1};


        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] >= target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        // Check if target exists
        if (start >= nums.length || nums[start] != target)
            return t;

        t[0] = start;

        end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        t[1] = end;
        return t;
    }
}
