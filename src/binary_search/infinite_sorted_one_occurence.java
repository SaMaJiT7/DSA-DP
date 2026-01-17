package binary_search;

public class infinite_sorted_one_occurence {
    public int occurence_one(int[] nums,int key){
        int low = 0;
        int high = 1;
        int res = 0;

        while(high < nums.length && key > nums[high]){
            low = high;
            high = high * 2;
        }

        high = Math.min(high, nums.length - 1);

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == key){
                res = mid;
                high = mid - 1;
            }

            else if(nums[mid] < key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res;
    }
}
