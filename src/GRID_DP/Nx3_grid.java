package GRID_DP;

import java.util.Arrays;

public class Nx3_grid {
    static int Mod = (int) 1000000007;

   static String[] states = {"RGY","RYG","RGR","RYR","GYR","GRY","GRG","GYG","YRG","YGR","YGY","YRY"};

   static int[][] memo;
    public int numOfWays(int n) {
        memo = new int[n][12];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        int result = 0;

        for(int curr = 0; curr < 12;curr++){
            result = (result + solve(n-1,curr)) % Mod;
        }
        return result;
    }

    static int solve(int n, int i){
        if(n == 0){
            return 1;
        }
        if(memo[n][i] != -1){
            return memo[n][i];
        }
        int result = 0;
        String lastpat = states[i];

        for(int curr = 0; curr < 12; curr++){
            if(curr == i) continue;

            String Currpat = states[curr];

            boolean conflict = false;
            for(int col = 0; col < 3; col++){
                if(Currpat.charAt(col) == lastpat.charAt(col)){
                    conflict = true;
                    break;
                }
            }
            if(!conflict){
                result = (result + solve(n-1,curr)) % Mod;
            }
        }
        return memo[n][i] = result;
    }
}
