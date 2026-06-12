package Leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class separate_digits {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(nums[i] < 9){
                ans.add(nums[i]);
            }
            else{
                List<Integer> elements = getElements(nums[i]);
                for(int j = elements.size()-1; j >= 0; j--){
                    ans.add(elements.get(j));
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    public List<Integer> getElements(int n){
        List<Integer> ans = new ArrayList<>();
        int x = n;
        while(x != 0){
             int val = x % 10;
             ans.add(val);
             x = x/10;
        }
        return ans;
    }
}
