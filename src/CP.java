import java.util.Arrays;

public class CP {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int maxLen = 1;

        for (int j = 0; j < n; j++) {
            while (nums[j] > (long)k * nums[i]) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return n - maxLen;
    }


    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int totaltime = 0;
        int min = Integer.MAX_VALUE;
        int landtime = 0;
        if(landStartTime[0] < waterStartTime[0]){
            for(int i = 0; i<n; i++){
                 landtime = landtime + Math.min(min,landStartTime[i] + landDuration[i]);

                 if(landtime == waterStartTime[i]){
                     totaltime = totaltime +(landtime + waterDuration[i]);
                }
            }

        }
        else{
            int watertime =0;
            for(int i = 0; i<m; i++){
                watertime = watertime + Math.min(min,waterStartTime[i] + waterDuration[i]);

                if(watertime == landStartTime[i]){
                    totaltime = totaltime +(watertime + landDuration[i]);
                }
            }
        }

        return totaltime;
    }
}
