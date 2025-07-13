public class LeetCode_Position {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        searchrange(nums,target);
    }
    static int[] searchrange(int[] nums, int target){
        int[] ans = {-1,-1};

        int start = range(nums,target,true);
        int end = range(nums,target,false);

        ans[0] = start;
        ans[1] = end;

        return ans;
    }
    static int range(int[] nums , int target, boolean findfirstIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int Mid = start + (end - start)/2;

            if(nums[Mid] < target){
                start = Mid + 1;
            }
            else if (nums[Mid] > target) {
                end = Mid - 1;
            }
            else {
                ans = Mid;
                if(findfirstIndex){
                    end = Mid - 1;
                }
                else {
                    start = Mid + 1;
                }
            }
        }
        return ans;
    }
}
