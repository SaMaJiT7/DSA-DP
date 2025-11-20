package LC_QUestion;

public class fibo_array {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxlength = 0;
        int length = 2;
        if(n <= 2){
            return n;
        }
        for(int i = 2; i < n; i++){
            if(nums[i-2] + nums[i-1] == nums[i]){
                length++;
            }
            else{
                length = 2;
            }
            maxlength = Math.max(maxlength,length);
        }
        return maxlength;
    }
}
