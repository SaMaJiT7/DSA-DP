package Leetcode_daily;

public class superPOW {
    static int mod  = 1337;
    public int superPow(int a, int[] b) {
        if(a == 1) return 1;

        long base = a % mod;
        long result = myPow(base,b[0]);
        for(int i = 1; i < b.length; i++){
            result = (myPow(result,10) * myPow(base,b[i])) % mod;
        }
        return (int) result;
    }
    public long myPow(long a, long b){
        if(b == 0){
            return 1;
        }
        long half = myPow(a,b/2);
        long ans = (half * half) % mod;

        if((b&1) != 0){
            ans = (ans * a) % mod;
        }

        return ans;
    }
}
