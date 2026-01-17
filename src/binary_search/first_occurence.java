package binary_search;

public class first_occurence {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int res = -1;
        int[] ans = {-1,-1};

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                res = mid;
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        ans[0] = res;

        res = -1;
        high = n-1;

        low = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                res = mid;
                low = mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        ans[1] = res;

        // Check if target exists
        return ans;

    }
}
