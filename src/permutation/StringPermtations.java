package permutation;

import java.util.ArrayList;

public class StringPermtations {
    public static void main(String[] args) {
        String p = "";
        String up = "abc";
        System.out.println(PermutationList1(p,up));
    }
    static ArrayList<String> PermutationList(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for(int i =0; i <= p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(PermutationList(f + ch + s,up.substring(1)));
        }
        return ans;
    }
    static int PermutationList1(String p , String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for(int i =0; i <= p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = count + PermutationList1(f + ch + s,up.substring(1));
        }
        return count;
    }
}
