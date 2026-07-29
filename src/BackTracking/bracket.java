package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class bracket {
    public List<String> generateParenthesis(int n) {
        List<String> Result = new ArrayList<>();
        int total = 2 * n;
        StringBuilder s = new StringBuilder();
        solve(n,total,Result,s,0,0);
        return Result;
    }
    private void solve(int n, int total,List<String> Result,StringBuilder s,int opencnt,int closecnt){
        if(s.length() == total){
            Result.add(s.toString());
            return;
        }
        if(opencnt < n){
            s.append('(');
            solve(n,total,Result,s,opencnt+1,closecnt);
            s.deleteCharAt(s.length()-1);
        }
        if(closecnt < opencnt){
            s.append(')');
            solve(n,total,Result,s,opencnt,closecnt+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
