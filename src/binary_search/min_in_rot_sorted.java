package binary_search;

public class min_in_rot_sorted {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high-low)/2;

            boolean prevcheck = (mid == 0 || nums[mid] < nums[mid-1]);
            boolean nextcheck = (mid == n-1 || nums[mid] < nums[mid+1]);
            
            if(prevcheck && nextcheck){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]){
                low = mid+1;
            } else if (nums[mid] <= nums[high]) {
                high = mid-1;
            }
        }
        return -1;
    }
}
