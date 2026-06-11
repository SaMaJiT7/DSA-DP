package Two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < n-2; i++){
            int j = i+1;
            int k = n-1;
            while(j < k){
                if(nums[i] == nums[j]+nums[k]){
                    answer.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;

                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
                else if(nums[i] < nums[j]+nums[k]){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return answer;
    }
}
