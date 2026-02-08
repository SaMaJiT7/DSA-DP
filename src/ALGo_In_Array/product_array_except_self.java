package ALGo_In_Array;

import java.util.Arrays;

public class product_array_except_self {
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] answer = new int[n];
//        long prod = 1;
//        int zero = 0;
//        for(int i = 0; i < n; i++){
//            if(nums[i] == 0){
//                zero += 1;
//            }
//            else{
//                prod = prod * nums[i];
//            }
//        }
//        if(zero > 1){
//            Arrays.fill(answer,0);
//        }
//        else if(zero == 1) {
//            for (int i = 0; i < n; i++) {
//                if (nums[i] != 0) {
//                    answer[i] = 0;
//                } else {
//                    answer[i] = (int) prod;
//                }
//            }
//        }
//        else{
//            for(int i = 0; i < n; i++){
//                answer[i] = (int) prod / nums[i];
//            }
//        }
//        return answer;
//    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for(int i = n-2; i >= 0; i--){
           suffix[i] = suffix[i+1] * suffix[i+1];
        }
        for(int i = n-1; i >= 0; i--){ nums[i] = prefix[i] * suffix[i]; }
        return nums;
    }
}
