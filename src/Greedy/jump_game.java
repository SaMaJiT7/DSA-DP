package Greedy;

public class jump_game {
//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        int maxreach = 0;
//        int i = 0;
//        int j = n;
//        if(n <= 1){
//            return true;
//        }
//        while(i <= maxreach){
//            maxreach = Math.max(maxreach,i+nums[i]);
//            if(maxreach >= j-1){
//                return true;
//            }
//            i++;
//        }
//        return false;
//    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n-1;

        for(int i = n-2; i >= 0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}
