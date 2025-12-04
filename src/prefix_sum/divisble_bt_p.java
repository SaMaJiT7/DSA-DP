package prefix_sum;

import java.nio.IntBuffer;
import java.util.HashMap;

public class divisble_bt_p {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int rem = (int) (prefix[n-1] % p);
        if(rem == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < n; i++){
            int curr = (int) (prefix[i] % p);
            int need = (curr - rem + p) % p;
            if(map.containsKey(need)) {
                int sublen = i - map.get(need);
                min = Math.min(sublen,min);
            }
            map.put(curr,i);
        }
        // if min was not updated OR the only possible removal is whole array -> -1
        if (min == Integer.MAX_VALUE || min == n) return -1;
        return min;
    }
}
