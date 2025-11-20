package LC_QUestion;

public class newarr {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }
        while(n > 1) {
            int[] newarr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                newarr[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = newarr;
            n = nums.length;
        }
        return nums[0];
    }
}
