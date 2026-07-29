package LC_QUestion;

public class count_good_number {
    static int mod = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n+1)/2;

        // each even position have 5 digits between 0 and 9 which are 0,1,4,6,8;
        // each odd position have 4 digits between 0 and 9 which are 2,3,5,7;

        long countofwaysforEven = myPow(5,even);
        long countofwaysforOdd = myPow(4,odd);
        long ans = (countofwaysforEven * countofwaysforOdd) % mod;
        return (int) ans;
    }
    public long myPow(long a, long b){
        if(b == 0){
            return 1;
        }
        long half = myPow(a,b/2);
        long ans = half * half;
        if((b & 1)  != 0){
            ans = (ans * a) % mod;
        }
        return ans;
    }
}
