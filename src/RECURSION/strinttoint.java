package RECURSION;

public class strinttoint {
    public int myAtoi(String s) {
        int n = s.length();
        long ans = 0;
        int sign = 1;
        boolean started = false;
        boolean signset = false;
        int result = solve(s,0,n,ans,sign,started,signset);
        return result;
    }
    public int solve(String S, int i, int n,long ans,int sign,boolean started, boolean signset){
        if(i == n){
            return (int)((sign) * ans);
        }
        char ch = S.charAt(i);
        if (ch == ' ' && !started && !signset) {
            return solve(S, i + 1, n,ans,sign,started,signset);
        }
        if ((ch == '-' || ch == '+') && !started && !signset){
            sign = (ch == '-') ? -1 : 1;
            signset = true;
            return solve(S, i + 1, n, ans,sign,started,signset);
        }
        if(ch >= '0'  &&  ch <= '9') {
            int val = ch - '0';
            started = true;
            if(sign == 1){
                if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && val > 7 )){
                    return Integer.MAX_VALUE;
                }
            }
            else{
                if(ans > Integer.MAX_VALUE/ 10 || (ans == Integer.MAX_VALUE / 10 && val > 8 )){
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans * 10 + val;
            return solve(S,i + 1, n,ans,sign,started,signset);
        }
        return (int) ((sign) * ans);
    }
}
