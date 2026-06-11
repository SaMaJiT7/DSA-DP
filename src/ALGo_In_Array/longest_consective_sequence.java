package ALGo_In_Array;

import java.util.HashMap;
import java.util.HashSet;

public class longest_consective_sequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        int max_len = 0;
        for(int val : set){
            if(!set.contains(val-1)){
                int len = 1;
                while(set.contains(val+1)){
                    val = val+1;
                    len += 1;
                }
                max_len = Math.max(max_len,len);
            }
        }
        return max_len;
    }
}
