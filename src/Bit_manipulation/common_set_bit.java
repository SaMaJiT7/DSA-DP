package Bit_manipulation;

public class common_set_bit {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(maxProduct(nums));
    }
    public static long maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            if((nums[i] & nums[j]) == 0) {
                max = Math.max(max, nums[i] * nums[j]);
                j--;
            }
            else{
                j--;
            }
            i++;
        }
        return (long) max;
    }
}
