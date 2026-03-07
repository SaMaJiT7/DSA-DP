package Bit_manipulation;

public class concate_binary_str {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long ans = 0;
        for(int i = 1; i <= n; i++){
            int bitlength = (int) (log2(i) + 1);
            ans = ((ans << bitlength)%mod + i) % mod;
        }
        return (int) ans;
    }
    public static double log2(double value) {
        // Use the identity: log₂(x) = Math.log(x) / Math.log(2)
        return Math.log(value) / Math.log(2);
    }
}
