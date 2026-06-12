package Bit_manipulation;

import java.util.Arrays;

public class sort_by_one {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] temp = new Integer[n];
        Arrays.sort(temp,(a,b) ->{
            int counta = Integer.bitCount(a);
            int countb = Integer.bitCount(b);

            if(counta == countb){
                return Integer.compare(a,b);
            }
            return Integer.compare(counta,countb);
        });
        for(int i = 0; i < n; i++){
            arr[i] = temp[i];
        }

        return arr;
    }
}
