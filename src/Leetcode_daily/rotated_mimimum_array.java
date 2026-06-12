package Leetcode_daily;

public class rotated_mimimum_array {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high-low)/2;

            int next = (mid+1) % n;
            int prev = (mid-1+n) % n;
            if(nums[prev] > nums[mid] && nums[mid] < nums[next]){
                return nums[mid];
            }
            else{
                if(nums[low] <= nums[mid]){
                    low = mid+1;
                }
                else if(nums[mid] <= nums[high]){
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
