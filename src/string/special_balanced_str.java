package string;

import java.util.ArrayList;
import java.util.Collections;

public class special_balanced_str {
    public String makeLargestSpecial(String s) {
        int balanced = 0;
        StringBuilder ans = new StringBuilder();
        ArrayList<String> blocks = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                balanced += 1;
            }
            else{
                balanced -= 1;
            }

            if(balanced == 0){
                String b = makeLargestSpecial(s.substring(start+1, i));
                blocks.add("1"+b+"0");
                start = i+1;
            }
        }
        Collections.sort(blocks,Collections.reverseOrder());
        for(String s1 : blocks){
            ans.append(s1);
        }
        return ans.toString();
    }
    public String solve(String s){
        int balanced = 0;
        StringBuilder ans = new StringBuilder();
        ArrayList<String> blocks = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                balanced += 1;
            }
            else{
                balanced -= 1;
            }

            if(balanced == 0){
                String b = solve(s.substring(start+1, i));
                blocks.add("1"+b+"0");
                start = i+1;
            }
        }
        Collections.sort(blocks,Collections.reverseOrder());
        for(String s1 : blocks){
            ans.append(s1);
        }
        return ans.toString();
    }
}
