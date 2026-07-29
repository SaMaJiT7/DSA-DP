package Leetcode_daily;

import java.util.HashMap;

public class numOfStrings {
    public static void main(String[] args){
        String[] patterns = {"a","b","c"};
        String word = "aaaaabbbbb";
        int ans = numOfStrings(patterns,word);
        System.out.println(ans);
    }
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String value : patterns){
            if(word.contains(value)){
                count += 1;
            }
        }
        return count;
    }
}
