package ALGo_In_Array;

import java.util.HashMap;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i]-target)){
                int idx = map.get(nums[i]-target);
                return new int[]{idx,i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
