package LC_QUestion;

public class minioperation {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] != first){
                return 1;
            }
        }
        return 0;
    }
}
