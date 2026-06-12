package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class palindrome_partitioning {
    int[][] t ;
    public List<List<String>> partition(String s) {
        int n = s.length();
        this.t = new int[n][n];
        for(int[] row : t) Arrays.fill(row,-1);
        List<List<String>> Result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(s,0,ans,Result);
        return Result;
    }
    public void solve(String s, int start, List<String> ans, List<List<String>> Result){
        if(start == s.length()){
            Result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(ispalindrome(start,i,s)){
                ans.add(s.substring(start,i+1));
                solve(s,i+1,ans,Result);
                ans.remove(ans.size()-1);
            }
        }
    }
    public boolean ispalindrome(int i , int j, String s){
        if(i > j) return true;

        if(t[i][j] != -1){
            return (t[i][j] == 1);
        }
        if(s.charAt(i) == s.charAt(j)){
            boolean ok = ispalindrome(i+1,j-1,s);
            t[i][j] = ok ? 1 : 0;
            return ok;
        }

        t[i][j] = 0;
        return false;
    }
}
