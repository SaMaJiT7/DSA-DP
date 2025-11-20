package Hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class removeAnagram {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = "";
        for(int i = 0; i < words.length; i++){
            String now = sortarr(words[i]);

            if(!now.equals(prev)){
                ans.add(words[i]);
            }
        }
        return ans;

//        List<String> ans = new ArrayList<>();
//        int n = words.length;
//
//        ans.add(words[0]);
//        for(int i = 1; i < n; i++){
//
//            if(!validanagram(words[i],words[i-1])){
//                ans.add(words[i]);
//            }
//        }
//        return ans;
    }

//    public boolean validanagram(String post,String pre){
//        if (post.length() != pre.length()) return false;
//
//        HashMap<Character,Integer> now = new HashMap<>();
//        HashMap<Character,Integer> prev = new HashMap<>();
//
//
//        for(char ch: post.toCharArray()){
//            now.put(ch,now.getOrDefault(ch,0)+1);
//        }
//        for (char ch1: pre.toCharArray()){
//            prev.put(ch1,prev.getOrDefault(ch1,0)+1);
//        }
//
//       return prev.equals(now);
//    }
    public String sortarr(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
