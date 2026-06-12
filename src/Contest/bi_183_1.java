package Contest;

public class bi_183_1 {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int swap = 0;
        while(i < j){
            while(nums[i] != 0 && i < j){
                i++;
            }
            while(nums[j] == 0 && i < j){
                j--;
            }
            if(nums[i] == 0 && i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
                swap += 1;
            }
        }
        return swap;
    }
}
