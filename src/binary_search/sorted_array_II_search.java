package binary_search;

public class sorted_array_II_search {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = start + (end-start)/2;

            while (start < end && nums[start] == nums[mid] && nums[end] == nums[mid]) {
                start++;
                end--;
            }
            if(target == nums[mid]){
                return true;
            }
            else if(nums[mid] <= nums[end]){
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            else{
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
