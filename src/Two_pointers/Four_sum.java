package Two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-3; i++){
            for(int j = i+1; j < n-2; j++){
                if(i > 0 && nums[i] == nums[i-1]) continue;
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k < l){
                    List<Integer> ans = new ArrayList<>();
                    long sum = sum(nums[i],nums[j],nums[k],nums[l]);
                    if(sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                        k++;
                        l--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return result;
    }
    public long sum(long a, long b, long c, long d){
        return (long) a+b+c+d;
    }
}
