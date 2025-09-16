package ALGo_In_Array;

public class Transform_Array {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int zerocount = 0;
        int onecount = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % 2 == 0){
                zerocount += 1;
            }
            else {
                onecount += 1;
            }
        }
        for (int i = 0; i < n ; i++){
            if(i <= zerocount){
                nums[i] = 0;
            }
            else {
                nums[i] = 1;
            }
        }
        return nums;
    }
}
