package LC_QUestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class minimum_abs_difference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        int mindiff = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++){
            int a = arr[i];
            int b = arr[i+1];
            int currentdiff = Math.abs(a-b);
            if(currentdiff < mindiff){
                mindiff = currentdiff;
                result.clear();
                result.add(Arrays.asList(a,b));
            }
            else if(currentdiff == mindiff){
                result.add(Arrays.asList(a,b));
            }
        }
        return result;
    }

}
