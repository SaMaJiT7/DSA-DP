package ALGo_In_Array;

import java.util.HashMap;
import java.util.HashSet;

public class subarray_balanced {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            HashSet<Integer> evenset = new HashSet<>();
            HashSet<Integer> oddset = new HashSet<>();
            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 0){
                    evenset.add(nums[j]);
                }
                else{
                    oddset.add(nums[j]);
                }

                if(evenset.size() == oddset.size()){
                    maxlen = Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
}
