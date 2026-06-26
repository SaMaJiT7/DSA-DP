package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxBuilding {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> nums = new ArrayList<>();
        
        nums.add(new int[]{1,0});
        Arrays.sort(restrictions,(a,b) -> Integer.compare(a[0],b[0]));
        boolean present = false;
        for(int[] row : restrictions){
            if(row[0] == n){
                present = true;
            }
            nums.add(row);

        }
        if(!present){ nums.add(new int[]{n,n-1});}


        for(int i = 0; i < nums.size()-1; i++){
            int dist = nums.get(i+1)[0] - nums.get(i)[0];
            nums.get(i+1)[1] = Math.min(nums.get(i+1)[1],nums.get(i)[1] + dist);
        }
        for(int i = nums.size()-1; i > 0; i--){
            int dist = nums.get(i)[0] - nums.get(i-1)[0];
            nums.get(i-1)[1] = Math.min(nums.get(i-1)[1],nums.get(i)[1] + dist);
        }

        int max = 0;
        for(int i = 0; i < nums.size()-1; i++){
            int[] b1 = nums.get(i);
            int[] b2 = nums.get(i+1);

            int dist = b2[0] - b1[0];
            int height = Math.abs(b1[1] - b2[1]);

            int extra = dist - height;
            int peak = Math.max(b1[1],b2[1]) + extra / 2;
            max = Math.max(peak,max);
        }
        return max;
    }
}
