package Sliding_Window;

public class maximum_avg{
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        double currentavg = Double.NEGATIVE_INFINITY;
        int i = 0;
        int j = 0;

        while(j < n){
            sum = sum + nums[j];

            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                double avg = sum / k;
                currentavg = Math.max(currentavg,avg);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return currentavg;
    }
}
