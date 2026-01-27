package LC_QUestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class min_abs_diff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int mindiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            int currentdiff = Math.abs(arr[i]-arr[i+1]);
            if(currentdiff < mindiff){
                mindiff = currentdiff;
                ans.clear();
            }
            if(currentdiff == mindiff){
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return ans;
    }
}
