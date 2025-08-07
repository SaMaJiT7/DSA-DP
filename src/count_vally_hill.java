public class count_vally_hill {
    public static void main(String[] args) {
        int[] nums = {2,4,1,1,6,5};
        System.out.println(nums);
    }
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int hill = 0;
        int valley = 0;

        for(int i = 1,lastdistinct =0; i < n-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i] > nums[lastdistinct] && nums[i] > nums[i+1]){
                hill++;
            }
            if(nums[i] < nums[lastdistinct] && nums[i] < nums[i+1]){
                valley++;
            }
            lastdistinct =i;
        }
        return hill + valley;
    }
}
