package stackandQueue;

import java.util.Arrays;

public class maxsum {
    static int maxsum(int x , int [] f , int [] s){
        return maxsum(x,f,s,0,0);
    }

    private static int maxsum(int x , int [] f , int [] s,int sum,int count){
        if(sum > x){
            return count;
        }

        if(f.length == 0 || s .length == 0){
            return count;
        }

        int ans1 = maxsum(x, Arrays.copyOfRange(f,1,f.length),s,sum+f[0],count+1);
        int ans2 = maxsum(x,f,Arrays.copyOfRange(s,1,s.length),sum+s[0],count+1);

        return Math.max(ans1,ans2);
    }
}
