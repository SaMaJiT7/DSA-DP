package RECURSION;

import java.util.ArrayList;
import java.util.List;

public class binary_string {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        rec(n,"",ans);
        return ans;
    }
   static void rec(int n , String s,List<String> ans){
        if(n == 0){
            ans.add(s);
            return;
        }
        if(s.isEmpty() || s.charAt(s.length()-1) == '1'){
            rec(n-1,s+'0',ans);
            rec(n-1,s+'1',ans);
        }
        else{
            rec(n - 1, s + '1',ans);
        }
    }
}
