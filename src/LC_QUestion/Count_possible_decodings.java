package LC_QUestion;

import java.util.Scanner;

public class Count_possible_decodings {
    public static int value() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = helper(0, s);
        return ans;
    }

    static int helper(int idx , String s){
        int n = s.length();
        if(idx == n){
            return 1;
        }

        if(idx == n-1){
            if(s.charAt(idx) == '*'){
                return 9;
            }
            else{
                return 1;
            }
        }
        if(s.charAt(idx) == '*'){
            //**
            if(s.charAt(idx+1) == '*'){
                int ans = 0;
                ans += helper(idx+1,s)*9;
                ans += helper(idx + 2,s)*16;
                return ans;
            }
            //*[]
            else{
                int ans = 0;
                ans += helper(idx+1,s)*9;
                int temp = s.charAt(idx+1) - '0';
                if(temp<= 6){
                    ans += helper(idx+2,s)*2;
                }
                else{
                    ans += helper(idx+2,s)*1;
                }
                return ans;
            }
        }
        else{
            //[]*
            if(s.charAt(idx+1) == '*'){
                int ans = 0;
                if(s.charAt(idx) != '0'){
                    ans += helper(idx+1,s)*1;
                }
                int temp = s.charAt(idx) - '0';
                if(temp <= 1){
                    ans += helper(idx+2,s)*9;
                }
                else if(temp == 2){
                    ans += helper(idx+2,s)*6;
                }
                return ans;
            }
            //[][]
            else{
                //single char
                int ans = 0;
                if(s.charAt(idx) != '0'){
                    ans += helper(idx+1,s)*1;
                }
                int temp = s.charAt(idx) - '0';
                if(temp <= 26){
                    ans += helper(idx+2,s)*1;
                }
                return ans;
            }
        }
    }
}
