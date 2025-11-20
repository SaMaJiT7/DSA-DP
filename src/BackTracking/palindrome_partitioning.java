package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class palindrome_partitioning {
    public List<List<String>> partition(String s) {
        List<String> ans = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(s,0,ans,result);
        return result;
    }
    static void helper(String s, int start,List<String> ans,List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(ans));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(ispalindrome(s,start,i)){
                ans.add(s.substring(start,i+1));
                helper(s,i+1,ans,result);
                ans.remove(ans.size()-1);
            }
        }
    }

    static boolean ispalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
