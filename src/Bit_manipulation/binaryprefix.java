package Bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class binaryprefix {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int n = nums.length;
        int curr = 0;
        for(int i = 0; i < n; i++){
            curr = (curr * 2 + nums[i]) % 5;

            result.add(i,(curr == 0));
        }
        return result;
    }
}
