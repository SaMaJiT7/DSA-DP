package Hashmap;

import java.util.ArrayList;

public class occurences {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        int m = queries.length;
        ArrayList<Integer> occur = new ArrayList<>();
        int[] ans = new int[m];

        for(int i = 0; i < n; i++){
            if(nums[i] == x){
                occur.add(i);
            }
        }

        for(int j = 0; j < m; j++){
            if(queries[j] > occur.size()){
                ans[j] = -1;
            }
            else{
                ans[j] = occur.get(queries[j] - 1);
            }
        }
        return ans;
    }
}
