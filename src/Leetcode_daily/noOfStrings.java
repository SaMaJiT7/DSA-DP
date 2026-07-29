package Leetcode_daily;

import java.util.HashMap;

public class noOfStrings {
//    public int numberOfSubstrings(String s) {
//        int[] freq = new int[3];
//        int i = 0;
//        int j = 0;
//        int n = s.length();
//        int count = 0;
//        while(j < n){
//            char in = s.charAt(j);
//            freq[in-'a']++;
//
//            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
//                char out = s.charAt(i);
//                freq[out-'a']--;
//                i++;
//            }
//            count += i;
//            j++;
//        }
//        return count;
//    }
      public int numberOfSubstrings(String s) {
          int idx_a = -1;
          int idx_b = -1;
          int idx_c = -1;
          int count = 0;
          for(int i = 0; i < s.length(); i++){
              char ch = s.charAt(i);
              if(ch == 'a'){
                  idx_a = i;
              }
              else if (ch == 'b'){
                  idx_b = i;
              }
              else{
                  idx_c = i;
              }
              int minindex = Math.min(idx_a,Math.min(idx_b,idx_c));
              count += minindex + 1;
          }
          return count;
      }
}
