package LC_QUestion;

public class equi_dist_1 {
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0,1};
        int k = 2;
        boolean ans = kLengthApart(nums,k);
        System.out.println(ans);
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int previdx = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                if(previdx != -1){
                    if((i - previdx) - 1 < k){
                        return false;
                    }
                }
                previdx = i;
            }
        }
        return true;
    }
}
