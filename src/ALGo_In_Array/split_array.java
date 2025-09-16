package ALGo_In_Array;

import java.util.Arrays;

public class split_array {
    public boolean isPossibleToSplit(int[] nums) {
        Arrays.sort(nums);
        int count = 1;

        for(int i = 1; i < nums.length;i++){
            if(nums[i] == nums[i-1]){
                count += 1;
            }
            if(count > 2){
                return false;
            }
        }
        return true;
    }
}
