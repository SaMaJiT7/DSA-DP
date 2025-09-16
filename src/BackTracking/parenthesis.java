package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        int total = n * 2;
        helper(parenthesis,ans,0,n,total,0,0);
        return parenthesis;
    }

    static void helper(List<String> parenthesis,StringBuilder ans , int i , int n, int N, int numOpen, int numClose){
        if(i == N){
            if(numOpen == n && numClose == n) {
                parenthesis.add(ans.toString());
                return;
            }
        }
        if(numOpen < n) {
            ans.append('(');
            helper(parenthesis, ans , i + 1, n, N, numOpen + 1,numClose);
            ans.setLength(ans.length()-1);
        }
        if(numClose < numOpen){
            ans.append(')');
            helper(parenthesis,ans,i+1, n, N, numOpen,numClose+1);
            ans.setLength(ans.length()-1);
        }
    }
}
