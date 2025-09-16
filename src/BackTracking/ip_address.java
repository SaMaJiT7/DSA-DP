package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class ip_address {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder s1 = new StringBuilder();
        helper(ans,s1,s,0,0);
        return ans;
    }

    static void helper(List<String> ans ,StringBuilder s1, String s, int index,int p){
        if(index == s.length() && p == 4){
            ans.add(s1.substring(0,s1.length()-1));
            return;
        }
        if(p >= 4){
            return;
        }
        for(int i = 1 ; i <= 3 ; i++){
            if(index + i > s.length()){
                break;
            }
            if(check(s.substring(index,index+i))){
                int prevlen = s1.length();
                String g = s.substring(index,index+i);
                helper(ans,s1.append(g).append('.'),s,index+i,p+1);
                s1.setLength(prevlen);
            }
        }
    }

    static boolean check(String s) {
        if (s.isEmpty()) return false;
        if (s.charAt(0) == '0' && s.length() > 1) return false;  // Leading zero invalid
        try {
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255;
        } catch (NumberFormatException e) {
            return false;  // Non-numeric
        }
    }
}
