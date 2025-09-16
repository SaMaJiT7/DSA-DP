package Two_pointers;

import java.util.HashMap;

public class remove_dp_sortedII {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int k = 0;
        for(int i = 0; i<n;i++){
            if(map.get(nums[i]) > 2){
                while(map.get(nums[i]) > 2){
                    map.remove(nums[i]);
                }
            }
            else if(map.get(nums[i]) <= 2){
                k++;
                nums[k]=nums[i];
            }
        }
        return k+1;
    }
}
