package ALGo_In_Array;

public class count_dominant {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        int totalsum = 0;
        int count = 0;
        for(int x : nums)  totalsum += x;

        for(int i = 0; i < n-1; i++){
            int rightsum = totalsum - nums[i];
            int rightcount = n-i-1;

            if((long) nums[i] * rightcount > rightsum){
                count++;
            }
        }
        return count;
    }
}
