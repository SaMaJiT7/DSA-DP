package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combinationsofchara {
    public List<String> solve(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> ans = new ArrayList<>();
        helper(0,new StringBuilder(),ans,s);
        return ans;
    }
    static void helper(int idx,StringBuilder s,List<String>ans,String nums){
        int n = nums.length();
        if(idx == n){
            ans.add(s.toString());
            return;
        }
        if(idx == n-1){
            int temp = nums.charAt(idx) -'0';
            s.append(temp+'a'-1);
            helper(idx+1,s,ans,nums);
            return;
        }
        if(nums.charAt(idx) == '0'){
            int temp = (nums.charAt(idx)-'0')*10 + (nums.charAt(idx+1)-'0');
            s.append(temp+'a'-1);
            helper(idx+1,s,ans,nums);
            return;
        }
        int temp = (nums.charAt(idx)-'0')*10 + (nums.charAt(idx+1)-'0');
        if(temp > 26){
            int g = nums.charAt(idx) -'0';
            s.append(g + 'a' - 1);
            helper(idx+1,s,ans,nums);
            return;
        }
        else{
            int g = nums.charAt(idx) -'0';
            s.append(g + 'a' - 1);
            helper(idx+1,s,ans,nums);
            s.deleteCharAt(s.length() - 1);
            s.append(temp + 'a' - 1);
            helper(idx+2,s,ans,nums);
        }
    }
}
