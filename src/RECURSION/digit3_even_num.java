package RECURSION;

import java.util.*;

public class digit3_even_num {
    TreeSet<Integer> ans;
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        this.ans = new TreeSet<>();
        boolean[] used = new boolean[n];
        solve(0,0,used,digits);
        int[] result = new int[ans.size()];
        int i = 0;
        for (int val : ans) {
            result[i++] = val;
        }
        return result;
    }
    public void solve(int depth,int digit, boolean[] used,int[] digits){
        if (depth == 3) {
            ans.add(digit);
            return;
        }
        for(int i = 0; i < digits.length; i++) {
            if(used[i]) continue;
            if(depth == 0 && digits[i] == 0) continue;
            if(depth == 2 && digits[i] % 2 != 0) continue;


            int newdigit = digit*10 + digits[i];
            used[i] = true;
            solve(depth+1,newdigit,used,digits);
            used[i] = false;
        }
    }
}
