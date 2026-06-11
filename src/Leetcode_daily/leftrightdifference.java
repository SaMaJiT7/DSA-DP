package Leetcode_daily;

public class leftrightdifference {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int totalsum = 0;
        for(int i = 0; i < n; i++){
            totalsum += nums[i];
        }
        int currsum = 0;
        for(int i = 0; i < n; i++){
            int leftsum = currsum;
            currsum += nums[i];
            int rightsum = totalsum - currsum;
            answer[i] = Math.abs(leftsum - rightsum);
        }

        return answer;
    }
}
