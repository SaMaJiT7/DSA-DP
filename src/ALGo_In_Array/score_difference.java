package ALGo_In_Array;

public class score_difference {
    public int scoreDifference(int[] nums) {
        int n = nums.length;
        int firstscore = 0;
        int secondscore = 0;
        boolean firstactive = false;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 1){
                firstactive = !firstactive;
            }
            if((i+1) % 6 == 0){
                firstactive = !firstactive;
            }
            if(firstactive){
                firstscore += nums[i];
            }
            else{
                secondscore += nums[i];
            }
        }
        return firstscore - secondscore;
    }
}
