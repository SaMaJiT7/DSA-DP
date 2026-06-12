package Leetcode_daily;

public class isGood_Array {
//        public boolean isGood(int[] nums) {
//            int n = nums.length;
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < n; i++) {
//                max = Math.max(max, nums[i]);
//            }
//            if(max+1 != n) return false;
//            int[] freq = new int[max + 1];
//            for (int i = 0; i < n; i++) {
//                freq[nums[i]]++;
//            }
//            for (int i = 1; i < max; i++) {
//                if (freq[i] != 1) {
//                    return false;
//                }
//            }
//            return freq[max] == 2;
//        }
public boolean isGood(int[] nums) {
    int n = nums.length;
    int max = n-1;
    int maxcount = 0;
    for(int i = 0; i < n; i++){
        int val = Math.abs(nums[i]);
        if(val > max) {
            return false;
        }
        else if(val == max) maxcount++;

        if(nums[val] < 0){
            if(val != max) return false;
            else if (maxcount > 2) return false;
        }
        else{
            nums[val] *= -1;
        }
    }
    return true;
}
}
