package Leetcode_daily;

public class jump_gameIX {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = nums[0];
        for(int i = 1; i < n; i++){
            pref[i] = Math.max(pref[i-1],nums[i]);
        }
        suff[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; --i){
            suff[i] = Math.min(suff[i+1],nums[i]);
        }

        int[] ans = new int[n];
        ans[n-1] = pref[n-1];
        for(int i = n-2; i >= 0; i--){
            if(pref[i] <= suff[i+1]){
                ans[i] = pref[i];
            }
            else{
                ans[i] = ans[i+1];
            }
        }

        return ans;
    }
}
