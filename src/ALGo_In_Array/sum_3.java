package ALGo_In_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sum_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length-1;

            while(j < k){
                if(nums[i] == nums[j]+nums[k]){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                } else if (nums[i] < nums[j]+nums[k]) {
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return result;
    }
}
