package LC_QUestion;

import java.util.Arrays;

public class maximum_freq_after_operation {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = nums[0];
        for(int i = 1; i < nums.length;i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int[] freq = new int[max+k+1];
        Arrays.fill(freq,0);

        for(int num : nums){
            freq[num]++;
        }

        for(int i = 1; i <= max+k; i++){
            freq[i] += freq[i-1];
        }

        int result = 0;
        for(int target = 0; target <= max+k; target++){
            if(freq[target] == 0){
                continue;
            }
            int l = Math.max(0,target - k);
            int r = Math.min(max+k,target + k);

            int totalcount = freq[r] - (l > 0 ? freq[l-1] : 0);
            int targetcount = freq[target] - (target > 0 ? freq[target-1] : 0);
            int needtoconvert = totalcount - targetcount;

            int frequency = targetcount + Math.min(numOperations,needtoconvert);

            result = Math.max(frequency,result);
        }
        return result;
    }
}
