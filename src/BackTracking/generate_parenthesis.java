package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class generate_parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        helper(n,result,ans,0,0);
        return result;
    }
    public void helper(int n,List<String> result,StringBuilder ans,int opencnt,int closecnt){
        int total = 2*n;
        if(opencnt + closecnt == total){
            result.add(ans.toString());
            return;
        }
        if(opencnt < n){
            ans.append("(");
            helper(n,result,ans,opencnt+1,closecnt);
            ans.setLength(ans.length()-1);
        }
        if(closecnt < opencnt){
            ans.append(")");
            helper(n,result,ans,opencnt,closecnt+1);
            ans.setLength(ans.length()-1);
        }
    }
}
