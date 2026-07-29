package Leetcode_daily;

public class divisibleGame {
    static int mod = (int) 1_000_000_007;
    public int divisibleGame(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
        }

        long maxscore = Long.MIN_VALUE;
        long finalK = 2;
        for(int k = 2; k <= max; k++){
            int[] tempNum = new int[n];
            for(int i = 0; i < n; i++){
                if(nums[i] % k == 0){
                    tempNum[i] = nums[i];
                }
                else{
                    tempNum[i] = -nums[i];
                }
            }
            long maxsum = tempNum[0];
            long currsum = tempNum[0];

            for(int i = 1; i < n; i++){
                currsum = Math.max(currsum + tempNum[i],(long) tempNum[i]);
                maxsum = Math.max(maxsum,currsum);
            }
            if(maxscore < maxsum){
                maxscore = maxsum;
                finalK = k;
            }
        }
        long ans = (maxscore % mod) * (finalK % mod);
        return (int) ((ans % mod + mod) % mod);
    }
}
