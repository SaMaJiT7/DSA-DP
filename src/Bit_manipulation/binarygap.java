package Bit_manipulation;

public class binarygap {
    public int binaryGap(int n) {
        int[] bits = new int[32];
        int prev = -1;
        int maxlength = 0;
        int i = 0;
        while(n != 0){
            bits[i++] = n & 1;
            n = n >> 1;
        }

        for(int j = 0; j < i; j++){
            if(bits[j] == 1){
                if(prev == -1){
                    prev = j;
                }else{
                    maxlength = Math.max(maxlength,j-prev);
                    prev = j;
                }
            }
        }
        return maxlength;
    }
}
