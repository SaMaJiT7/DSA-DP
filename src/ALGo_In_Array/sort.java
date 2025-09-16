package ALGo_In_Array;

public class sort {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            if(nums[i] > nums[j]){
                swap(nums,nums[i],nums[j]);
                i++;
                j--;
            }
            else if(nums[i] < nums[j]){
                i++;
            }
            j--;
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
