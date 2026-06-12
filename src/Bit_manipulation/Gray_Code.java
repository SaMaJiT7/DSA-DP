package Bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class Gray_Code {
    public List<Integer> grayCode(int n) {
        int[] arr = new int[(1<<n)];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < (1 << n); i++){
            int val = i ^ (i >> 1);
            ans.add(val);
        }
        return ans;
    }
}
