package RECURSION;

import java.util.Arrays;

enum Result {
    TRUE, FALSE
}
public class regular_matching {
    Result[][] t;
    public boolean isMatch(String s, String p) {
        //return helper(0,0,s,p);
        t = new Result[s.length()+1][p.length()+1];

        return solve(0,0,s,p);
    }
    public boolean solve(int i, int j, String text,String pattern) {

        if (t[i][j] != null) {
            return t[i][j] == Result.TRUE;
        }

        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean firstcharactercheck = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));


            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                boolean taken = (firstcharactercheck && solve(i + 1, j, text, pattern));
                boolean nottaken = solve(i, j + 2, text, pattern);
                ans = taken || nottaken;
            }
            else{
                ans = (firstcharactercheck) && solve(i+1,j+1,text,pattern);
            }
        }
        t[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
//    public static boolean helper(int i , int j ,String s, String pattern){
//        if (j == pattern.length()) {
//            return i == s.length();
//        }
//
//        boolean firstcharactercheck = false;
//        if(i < s.length()  && (pattern.charAt(j) == s.charAt(i) || pattern.charAt(j) == '.')){
//            firstcharactercheck = true;
//        }
//
//        if(j+1 < pattern.length()  && pattern.charAt(j+1) == '*'){
//            boolean taken = (firstcharactercheck && helper(i+1,j,s,pattern));
//            boolean nottaken = helper(i,j+2,s,pattern);
//
//            return  taken || nottaken;
//        }
//
//        return (firstcharactercheck) && helper(i+1,j+1,s,pattern);
//    }
}
