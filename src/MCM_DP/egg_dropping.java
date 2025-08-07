package MCM_DP;

import java.util.Arrays;

public class egg_dropping {
    static int[][] t = new int[11][51];
    public static void main(String[] args) {
        for(int[] row : t){
            Arrays.fill(row,-1);
        }
        System.out.println(egg_drop(3,5));
    }

    public static int egg_drop(int e , int f){
        if(e == 1){
            return f;
        }
        if(f == 0 || f == 1){
            return f;
        }

        if(t[e][f] != -1){
            return t[e][f];
        }
        int min = Integer.MAX_VALUE;
        int down ;
        int up;
        for(int k = 1; k <= f ; k++){
            if(t[e-1][k-1] != -1){
                down =  t[e-1][k-1];
            }
            else{
                down = egg_drop(e-1,k-1);
                t[e-1][k-1] = down  ;
            }

            if(t[e][f-k] != -1){
                up = t[e][f-k];
            }
            else {
                up = egg_drop(e,f-k);
                t[e][f-k] = up;
            }

            int temp = 1 + Math.max(down,up);
            min = Math.min(min,temp);
        }

        return t[e][f] = min;
    }
}
