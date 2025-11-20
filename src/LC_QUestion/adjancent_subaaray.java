package LC_QUestion;

import java.util.List;

public class adjancent_subaaray {
//    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
//        int n = nums.size();
//        for(int start = 0; start + 2*k < n; start++){
//            boolean first = isincreasing(nums,start,start+k);
//            boolean second = isincreasing(nums,start+k,start+2*k);
//
//            if(first && second){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean isincreasing(List<Integer> nums,int start , int end){
//        for(int i = start; i < end-1; i++){
//            if(nums.get(i) >= nums.get(i+1)){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;
        int curr = 1;

        int maxresult = 0;
        int n = nums.size();
        for(int i = 1; i < n; i++){
            if(nums.get(i-1) >= nums.get(i)){
                curr += 1;
            }
            else{
                prev = curr;
                curr = 1;
            }

            if(curr / 2 >= k){
                return true;
            }

            if(Math.min(prev,curr) >= k){
                return true;
            }
        }
        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int prev = 0;
        int k = 0;
        int curr = 1;
        for(int i = 1; i < n; i++){
            if(nums.get(i) > nums.get(i-1)){
                curr += 1;
            }
            else{
                prev = curr;
                curr = 1;
            }
            if(k < curr/2){
                k = curr/2;
            }

            if(Math.min(prev,curr) >= k){
                k = Math.min(prev,curr);
            }
        }
        return k;
    }
}
