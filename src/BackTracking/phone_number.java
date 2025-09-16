package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class phone_number {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        StringBuilder str= new StringBuilder();
        List<String> ans = new ArrayList<>();
        mapping(map);
        helper(ans,str,map,digits,0);
        return ans;
    }
    static void helper(List<String> ans,StringBuilder str ,HashMap<Character,String> map,String digits,int i){
        if(i >= digits.length()){
            if(!digits.isEmpty()) {
                ans.add(ans.toString());
            }
        }
        String s = map.get(digits.charAt(i));
        for(char ch : s.toCharArray()){
            str.append(ch);
            helper(ans,str,map,digits,i+1);
            str.deleteCharAt(str.length()-1);
        }
    }
    void mapping(HashMap<Character,String> map){
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
}
