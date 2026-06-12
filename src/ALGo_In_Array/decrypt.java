package ALGo_In_Array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class decrypt {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        Arrays.fill(ans,0);
        if(k > 0){
            for(int i = 0; i < n; i++){
                int sum = 0;
                for(int j = 1; j <= k; j++){
                    sum = sum + code[(i+j) % n];
                }
                ans[i] = sum;
            }
        }
        else if(k < 0){
            for(int i = 0; i < n; i++){
                int sum = 0;
                for(int j = 1; j <= -k; j++){
                    sum = sum + code[(i-j+n) % n];
                }
                ans[i] = sum;
            }
        }
        return ans;
    }
}
