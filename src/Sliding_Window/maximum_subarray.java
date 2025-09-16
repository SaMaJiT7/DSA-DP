package Sliding_Window;

public class maximum_subarray {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2};
        int k = 2;
        System.out.println(subarraySum(arr,k));
    }
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int count= 0;
        while(j < n){
            sum = sum + nums[j];

            if(sum < k){
                j++;
            }
            else if (sum == k) {
                count = count + 1;
                j++;
            }
            else if (sum > k) {
                while(sum > k){
                    sum = sum - nums[i];
                    i++;
                }

                if(sum == k){
                    count = count + 1;
                    j++;
                }
            }
        }
        return count;
    }
}
