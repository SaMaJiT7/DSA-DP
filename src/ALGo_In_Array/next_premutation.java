package ALGo_In_Array;

public class next_premutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            int low = 0;
            int high = n-1;
            while(low <= high){
                swap(nums,low,high);
                low++;
                high--;
            }
        }
        else {
            int nextgreat = 0;
            for(int i = n-1; i > pivot; i--){
                if(nums[i] > nums[pivot]){
                    nextgreat = i;
                    break;
                }
            }
            swap(nums, pivot, nextgreat);
            int low = pivot + 1;
            int high = n - 1;
            while (low < high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
