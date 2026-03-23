package Leetcode_daily;

public class complement_tenBase {
//    public int bitwiseComplement(int n) {
//        if (n == 0) return 1;
//        StringBuilder result = new StringBuilder();
//        while(n != 0){
//            result.append((n & 1) == 1 ? 0 :  1);
//            n = n >> 1;
//        }
//        result.reverse();
//
//        return Integer.parseInt(result.toString(),2);
//    }
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = 0;
        while(mask < n){
            mask = (mask << 1) | 1;
        }
        return mask ^ n;

    }
}
