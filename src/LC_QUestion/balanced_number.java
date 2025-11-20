package LC_QUestion;

import java.util.HashMap;

public class balanced_number {
    public int nextBeautifulNumber(int n) {
//        int lastnum = 1224444;
//
//        for(int i = n+1; i <= lastnum; i++){
//            if(balanced(i)){
//                return i;
//            }
//        }
//        return 0;
        int digcount = 0;
        int num = n;
        while(num > 0){
            digcount++;
            num = num/10;
        }
        int[] digitcount = new int[10];
        for(int i = 1; i <= 9; i++){
            digitcount[i] = i;
        }

        int x = backtrack(n,0,digcount,digitcount);
        if(x == 0){
            return backtrack(n,0,digcount+1,digitcount);
        }
        return x;
    }
    int backtrack(int n, int curr, int digitleft,int[] digitcount){
        if(digitleft == 0){
            if(curr > n && balanced(curr)){
                return curr;
            }
        }
        int result = 0;
        for(int d = 1; d <= 9; d++){
            if(digitcount[d] > 0 && digitcount[d] <= digitleft){
                digitcount[d]--;
                result = backtrack(n,curr*10 + d,digitleft-1,digitcount);
                if(result != 0) break;
                digitcount[d]++;
            }
        }
        return result;
    }
    boolean balanced(int num){
        int[] count = new int[10];
        while(num > 0){
            int digit = num % 10;
            count[digit]++;
            num /= 10;
        }

        for(int digit = 1; digit < 10; digit++){
            if(count[digit] > 0 && count[digit] != digit){
                return false;
            }
        }
        return true;
    }
}
