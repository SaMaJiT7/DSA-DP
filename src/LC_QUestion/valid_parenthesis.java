package LC_QUestion;

import java.util.Arrays;

public class valid_parenthesis {
    static int[][] t;
    public boolean checkValidString(String s) {
        int n = s.length();
        t = new int[n][n+1];
        for (int[] row : t) Arrays.fill(row, -1);
        int idx = 0;
        int count = 0;
        return helper(s,idx,count);
    }
    public static boolean helper(String s,int idx,int count){
        int n = s.length();
        if(count < 0){
            return false;
        }

        if(idx == n){
            return (count == 0);
        }

        if (t[idx][count] != -1) return t[idx][count] == 1;


        char ch = s.charAt(idx);
        boolean result;
        if(ch == '('){
            result = helper(s,idx+1,count+1);
        }
        else if(ch == ')'){
            result = helper(s,idx+1,count-1);
        }
        else{
            result =  helper(s,idx+1,count+1) || helper(s,idx+1,count-1) || helper(s,idx+1,count);
        }


        t[idx][count] = result ? 1 : 0;
        return result;
    }
}
