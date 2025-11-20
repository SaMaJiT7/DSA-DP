package Bit_manipulation;

public class Hard_nto0 {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        long[] F = new long[32];


        F[0] = 1;
        for(int i = 1; i <= 31; i++){
            F[i] = 2*F[i-1] + 1;
        }

        int ans = 0;
        int sign = 1;

        for(int i = 31; i >= 0; i--){

            int ith_bit = ((1 << i) & n);

            if(ith_bit == 0){
                continue;
            }

            if(sign == 1){
                ans += F[i];
            }
            else if(sign == -1){
                ans -= F[i];
            }

            sign = sign * (-1);
        }
        return ans;
    }

}
