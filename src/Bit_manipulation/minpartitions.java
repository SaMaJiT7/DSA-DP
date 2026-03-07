package Bit_manipulation;

public class minpartitions {
    public int minPartitions(String n) {
        int max = 0;
        int l = n.length();
        for(int i = 0; i < l; i++){
            int val = n.charAt(i) - '0';
            if(val > max){
                max = val;
            }
        }
        return max;
    }
}
