package ALGo_In_Array;

public class transform_arr {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i]  > 0){
                int idx = (i + nums[i]) % n;
                result[i] = nums[idx];
            }
            else if(nums[i] < 0){
                int idx = ((i+nums[i] % n + n ) % n);
                result[i] = nums[idx];
            }
            else{
                result[i] = 0;
            }
        }
        return result;
    }
}
