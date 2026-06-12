package Leetcode_daily;

public class Find_MIn_Hard_BS {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low < high){
            if(nums[low] < nums[high]) return nums[low];

            int mid = low + (high-low)/2;

            if(nums[mid] < nums[low] && nums[mid] < nums[high]){
                return nums[mid];
            }
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else if(nums[mid] < nums[high]){
                high = mid;
            }
            else{
                high--;
            }
        }
        return nums[low];
    }
}
