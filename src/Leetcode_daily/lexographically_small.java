package Leetcode_daily;

public class lexographically_small {
    int count = 0;
    String result = "";
    public String getHappyString(int n, int k) {
//        int total = 3 * (int)(Math.pow(2,n-1));
//        char[] character = {'a','b','c'};
//        if(k > total) return "";
//        StringBuilder result = new StringBuilder();
//        char prev = 0;
//        for(int i = 0; i < n; i++){
//            for(char ch : character){
//                if(ch == prev) continue;
//
//                int block = (int)Math.pow(2,n-i-1);
//
//                if(k > block){
//                    k -= block;
//                }
//                else{
//                    result.append(ch);
//                    prev = ch;
//                    break;
//                }
//            }
//        }
//        return result.toString();

        int total = 3 * (int) Math.pow(2,n-1);
        if(k > total) return "";
        StringBuilder result = new StringBuilder();
        solve(n,k,result);
        return result.toString();
    }
    public void solve(int n, int k,StringBuilder s){
        if(s.length() == n) {
            count++;

            if(count == k) {
               result = s.toString();
            }
            return;
        }

        char[] character = {'a','b','c'};

        for(char ch : character){
            if(s.length() > 0 && s.charAt(s.length()-1) == ch) continue;


            s.append(ch);
            solve(n,k,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
