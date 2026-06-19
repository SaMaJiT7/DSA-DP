package Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;

public class min_window_substring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int min = Integer.MAX_VALUE;
        String answer = "";
        if(n > m){
            return "";
        }
        int i = 0;
        int[] charFreq = new int[128];

        for(char c : t.toCharArray()){
            charFreq[c]++;
        }
        int count = 0;
        for(int val : charFreq){
            if(val >= 1){
                count += 1;
            }
        }

        for(int j = 0; j < m; j++){
            int enter = s.charAt(j);
            charFreq[enter]--;
            if(charFreq[enter] == 0){
                count--;
            }

            while(count == 0){
                if(j - i + 1 < min){
                    min = j - i + 1;
                    answer = s.substring(i,j);
                }

                int leave = s.charAt(i);
                charFreq[leave]++;
                if(charFreq[leave] == 1){
                    count = count + 1;
                }
                i++;
            }
        }
        return answer;
    }
}
