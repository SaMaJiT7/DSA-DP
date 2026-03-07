package Bit_manipulation;

import java.util.Arrays;

public class sortbyBits {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] temp = new Integer[n];
        for(int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp,(a,b) -> {
            int bitA = find1s(a);
            int bitB = find1s(b);

            if(bitA == bitB){
                return a - b;
            }
            return bitA-bitB;
        });
        for(int i = 0; i < temp.length; i++){
            arr[i] = temp[i];
        }
        return arr;
    }

    public int find1s(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
