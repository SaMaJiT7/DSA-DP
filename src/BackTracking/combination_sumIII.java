package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class combination_sumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combisum3 =new ArrayList<>();
        helper(1,k,n,new ArrayList<>(),combisum3);
        return combisum3;
    }
    static void helper(int start ,int k , int n, List<Integer>ans,List<List<Integer>> combisum3){
        if(k == 0 && n ==0){
            combisum3.add(new ArrayList<>(ans));
            return;
        }
        if(k == 1 && n == 1){
            return;
        }

        for(int i = start; i <= 9 ; i++){
            if(n - i < 0 || k - 1 < 0){
                break;
            }
            if(i <= n) {
                ans.add(i);
            }
            helper(i+1,k-1,n-i,ans,combisum3);
            ans.remove(ans.size()-1);
        }
    }
}
