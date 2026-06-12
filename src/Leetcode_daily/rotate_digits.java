package Leetcode_daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class rotate_digits {
//    public int rotatedDigits(int n) {
//        int[] variation = new int[10];
//        for(int i = 0; i < 10; i++){
//            if(i == 7 || i == 3 || i == 4){
//               variation[i] = -1;
//            }
//            else if(i == 0 || i == 1 || i == 8){
//                variation[i] = 0;
//            }
//            else{
//                variation[i] = 1;
//            }
//        }
//
//        int count = 0;
//        for(int i = 1; i <= n ; i++){
//            boolean changed = false;
//            boolean invalid = false;
//            int x = i;
//            while(x != 0){
//                int val = x % 10;
//                if(variation[val] == -1){
//                    invalid = true;
//                    break;
//                }
//                else if(variation[val] == 1){
//                    changed = true;
//                }
//                x = x / 10;
//            }
//            if(changed && !invalid){
//                count++;
//            }
//        }
//        return count;
//    }

    Integer[][][] t;
    int len;
    public int rotatedDigits(int n) {
         char[] digits = String.valueOf(n).toCharArray();
         len = digits.length;
         t = new Integer[len][2][2];

         return solve(0,1,0,digits);
     }
     public int solve(int pos, int tight,int changed,char[] digits){
        if(pos == len){
            return (changed == 1 ? 1 : 0);
        }

        if(t[pos][tight][changed] != null){
            return t[pos][tight][changed];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        int count = 0;

        for(int d = 0; d <= limit; d++){
            if(d == 3 || d == 4 || d == 7) continue;

            int nexttight = tight == 1 && d == limit ? 1 : 0;
            int nextchanged = changed;

            if(d == 2 || d == 5 || d == 6 || d == 9){
                nextchanged = 1;
            }

            count += solve(pos+1,nexttight,nextchanged,digits);
        }

        return t[pos][tight][changed] = count;
     }
}
