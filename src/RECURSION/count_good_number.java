package RECURSION;

public class count_good_number {
    int mod = (int) 1000000007;
    public int countGoodNumbers(long n) {
        long odd = 0;
        long even = 0;
        if(n % 2 == 0){
            odd = n / 2;
            even = n / 2;
        }
        else{
            even = n / 2 + 1;
            odd = n / 2;
        }
        long fivepowerEven = solve(5,even);
        long fourpowerOdd = solve(4,odd);
        long ans = (fivepowerEven * fourpowerOdd) % mod;
        return (int) (ans);
    }
    public long solve(int digit , long exp){
        long result;
        if(exp == 0){
            return 1;
        }
        if(exp % 2 == 0){
            long half = solve(digit ,(exp/2));
             result = (half * half)  % mod;
        }
        else{
            result = (digit * solve(digit,(exp-1)) % mod);
        }
        return result;
    }
}
