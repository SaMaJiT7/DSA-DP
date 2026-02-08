package ALGo_In_Array;

public class Tritonic_array {
    public boolean isTrionic(int[] nums) {
//        int p = 0;
//        int q = 0;
//        boolean foundp = false;
//        int n = nums.length;
//        for(int i = 0; i < n-1; i++){
//            if(nums[i] == nums[i+1]){
//                return false;
//            }
//            else if (nums[i] < nums[i+1]) {
//                continue;
//            }
//            else{
//                if(!foundp) {
//                    p = i;
//                    foundp = true;
//                }
//            }
//        }
//        if (!foundp || p == 0) return false;
//        boolean foundq = false;
//        for(int i = p; i < n-1; i++){
//            if(nums[i] == nums[i+1]){
//                return false;
//            }
//            else if(nums[i] > nums[i+1]){
//                continue;
//            }
//            else{
//                q=i;
//                foundq = true;
//                break;
//            }
//        }
//        if (!foundq || q == p) return false;
//
//        for(int i = q; i < n-1; i++){
//            if (nums[i] >= nums[i+1]) return false;
//        }
//        return true;
//    }
        int i = 0;
        int n = nums.length;
        while(i+1 < n && nums[i] < nums[i+1]){
            i++;
        }
        if(i == 0 || i == n-1) return false;

        while(i+1 < n && nums[i] > nums[i+1]){
            i++;
        }
        if(i == n-1) return false;

        while(i+1 < n && nums[i] < nums[i+1]){
            i++;
        }

        return i == n-1;
    }
}
