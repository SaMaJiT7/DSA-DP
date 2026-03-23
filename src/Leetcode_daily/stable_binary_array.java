package Leetcode_daily;

import java.util.Arrays;

public class stable_binary_array {
    static int mod = (int) (1e9+7);public int numberOfStableArrays(int zero, int one, int limit){

        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                for(int k = 0; k < 2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int onesleft = 0; onesleft <= one; onesleft++){
            for(int zerosleft = 0; zerosleft <= zero; zerosleft++){
                if(onesleft == 0 && zerosleft == 0){
                    continue;
                }
                int result = 0;
                for(int i = 1; i <= Math.min(limit,onesleft); i++){
                    result = (result + dp[zerosleft][onesleft-i][1]) % mod;
                }
                dp[zerosleft][onesleft][0] = result;

                result = 0;
                for(int i = 1; i <= Math.min(limit,zerosleft); i++){
                    result = (result + dp[zerosleft-i][onesleft][0]) % mod;
                }
                dp[zerosleft][onesleft][1] = result;
            }
        }
        int startOne = dp[zero][one][0];
        int startZero = dp[zero][one][1];
        return (startOne+startZero) % mod;
    }
    int[][][] dp = new int[201][201][2];
//    public int numberOfStableArrays(int zero, int one, int limit) {
//        for(int i = 0; i < 201; i++){
//            for(int j = 0; j < 201; j++){
//                for(int k = 0; k < 2; k++){
//                    dp[i][j][k] = -1;
//                }
//            }
//        }
//        int startone = solve(zero,one,limit,0);
//        int startzero = solve(zero,one,limit,1);
//        return startone+startzero;
//    }
//    public int solve(int zeroleft, int oneleft, int limit,int lastwasone){
//        if(zeroleft == 0 && oneleft == 0){
//            return 1;
//        }
//        int result = 0;
//        if(dp[zeroleft][oneleft][lastwasone] != -1){
//            return dp[zeroleft][oneleft][lastwasone];
//        }
//        if(lastwasone == 1){
//            for(int i = 1; i <= Math.min(limit,zeroleft); i++){
//                result = (result + solve(zeroleft-i,oneleft,limit,0)) % mod;
//            }
//        }
//        else{
//            for(int i = 1; i <= Math.min(limit,oneleft); i++){
//               result = (result + solve(zeroleft,oneleft-i,limit,1)) % mod;
//            }
//        }
//        return result;
//    }

}
