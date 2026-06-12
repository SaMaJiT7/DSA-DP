package Bit_manipulation;

public class counting_bits {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
//        for(int i = 1; i <= n; i++){
//
//            arr[i] = solve(i);
//        }
//        return arr;

        if(n == 0) return result;
        result[0] = 0;
        for(int i = 1; i <= n; i++){
            if(i % 2 == 1){
                result[i] = result[i/2]+1;
            }
            else{
                result[i] = result[i/2];
            }
        }
        return result;
    }
//    public int solve(int x){
//        int count = 0;
//        while(x != 0){
//            if((x&1) == 1){
//                count++;
//            }
//            x = x >> 1;
//        }
//
//        return count;
//    }
}
