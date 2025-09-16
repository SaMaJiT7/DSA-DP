package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combination = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(1,n,k,ans,combination);
        return combination;
    }

    static void helper(int start,int n ,int k ,List<Integer> ans,List<List<Integer>> combination){
        if(k == 0){
            combination.add(new ArrayList<>(ans));
            return;
        }

        for(int i = start ; i <= n-k+1; i++){
            ans.add(i);
            helper(i+1,n,k-1,ans,combination);
            ans.remove(ans.size() - 1);
        }
    }
}
