package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsII {
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,ans,result);
        return result;
    }
    private void solve(int idx,int[] nums,List<Integer> ans,List<List<Integer>> result){
        if(idx >= n){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = idx; i < n; i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }

            ans.add(nums[i]);
            solve(i+1,nums,ans,result);
            ans.removeLast();
        }
    }
}
