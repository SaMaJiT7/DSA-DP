package Leetcode_daily;

import java.util.Arrays;

public class sumAndMultiply {
    static int mod = (int) 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] prefixsum = new int[n];
        int[] prefixNumber = new int[n];
        int[] elementcount = new int[n];
        int[] ans = new int[n];

        int firstNum = s.charAt(0)-'0';
        prefixsum[0] = firstNum;
        if(firstNum != 0){
            prefixNumber[0] = firstNum;
            elementcount[0] = 1;
        }
        else{
            prefixNumber[0] = 0;
            elementcount[0] = 0;
        }

        for(int i = 1; i < n; i++){
            int num = s.charAt(i)-'0';

            prefixsum[i] = prefixsum[i-1] + num;

            if(num != 0){
                prefixNumber[i] = (int)(((10L * prefixNumber[i - 1] + num) % mod));
                elementcount[i] = elementcount[i-1] + 1;
            }
            else{
                prefixNumber[i] = prefixNumber[i-1];
                elementcount[i] = elementcount[i-1];
            }
        }

        int[] pow10 = new int[n+1];
        pow10[0] = 1;
        for(int i = 1; i <= n; i++){
            pow10[i] = (int) ((10L * pow10[i-1]) % mod);
        }

        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int k = elementcount[r] - ((l > 0) ? elementcount[l-1] : 0);

            long totalval = prefixNumber[r];
            long leftval = (l > 0) ? prefixNumber[l-1]  : 0;

            long scaledLeftVal = (leftval * pow10[k]) % mod;
            long x = (totalval - scaledLeftVal + mod) % mod;

            int sum = prefixsum[r] - ((l > 0) ? prefixsum[l-1] : 0);

            long ansQuery = (x * (sum % mod)) % mod;

            ans[i] = (int) ansQuery;
        }

        return ans;
    }
}
