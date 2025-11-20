package LC_QUestion;

import java.util.HashMap;

public class sneky_number{
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int j = 0;
        int[] ans = new int[2];

        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            else{
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}
