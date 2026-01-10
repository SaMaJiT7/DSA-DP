package number_theory;

import static java.lang.Math.round;

public class Four_DIVISORS {
    static int N = 10000006;

    static int[] prime = new int[N+1];

    static{
        for (int i = 0; i <= N; i++) {
            prime[i] = 1;
        }
        prime[0] = 0;
        prime[1] = 0;

        for (int i = 2; i * i <= N; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        int total =0;
        for(int i = 0; i < nums.length; i++){
            sum = isDivisor4(nums[i]);
            total += sum;
        }
        return total;
    }

    public static int isDivisor4(int n){
        // Case 1: check if N = p³
        int p = (int) Math.round(Math.cbrt(n));
        if (p > 1 && p * p * p == n && prime[p] == 1) {
            return 1 + p + p * p + n;
        }

        // Case B: check if n = p * q
        int p1 = -1, q1 = -1;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                int j = n / i;
                if(i != j && prime[i] == 1 && prime[j] == 1){
                    p1 = i;
                    q1 = j;
                    return 1 + i + j + n;
                }
            }
        }

        return 0;
    }
}
