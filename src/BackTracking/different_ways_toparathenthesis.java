package BackTracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class different_ways_toparathenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        int i = 0;
        int j = expression.length()-1;
        return helper(expression,0,j);
    }
    static List<Integer> helper(String expression,int i, int j){
        List<Integer> ans = new ArrayList<>();

        for(int k = i; k <= j ; k++) {
            char ch = expression.charAt(k);

            if (ch == '*' || ch == '+' || ch == '-') {
                List<Integer> leftvalue = helper(expression, i, k - 1);
                List<Integer> rightvalue = helper(expression, k + 1, j);

                for (int x : leftvalue) {
                    for (int y : rightvalue) {
                        if (ch == '-') ans.add(x - y);
                        if (ch == '+') ans.add(x + y);
                        if (ch == '*') ans.add(x * y);
                    }
                }
            }
        }
        if(ans.isEmpty()){
            ans.add(Integer.parseInt(expression.substring(i,j+1)));
        }
        return ans;
    }
}
