package Bit_manipulation;

public class single_number {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int k = 0; k < 32; k++){
            int temp = 1 << k;
            int count = 0;
            for(int val : nums){
                if((val & temp) != 0){
                    count++;
                }
            }
            if(count % 3 == 1){
                result = result | temp;
            }
        }
        return result;
    }
}
