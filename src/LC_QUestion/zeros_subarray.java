package LC_QUestion;

public class zeros_subarray {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int streak = 0;
        for(int num: nums){
            if(num == 0){
                streak += 1;
            }
            else{
                streak = 0;
            }
            count += streak;
        }
        return count;
    }
}
