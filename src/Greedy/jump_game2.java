package Greedy;

public class jump_game2 {
    public int jump(int[] nums) {
       int n = nums.length;
       int current_end = 0;
       int maxreach = 0;
       int jump = 0;

       for(int i = 0; i < n-1; i++){
           maxreach = Math.max(maxreach,i+nums[i]);

           if(nums[i] == 0){
               return 0;
           }
           if(i == current_end){
               jump += 1;
               current_end = maxreach;
           }

           if(i >= n-1){
               return jump;
           }
       }
       return 0;
    }
}
