package Sliding_Window;

import java.util.HashMap;

public class longest_substring {

    public int longest_substring(String s , int k){
        int i = 0;
        int j = 0;
        int n = s.length();
        int max = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j < n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j), 0) + 1);

            if(map.size() < k){
                j++;
            }
            else if (map.size() == k) {
                max = Math.max(max,j-i+1);
                j++;
            }
            else if (map.size() > k) {
                while(map.size() > k){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                if(map.size() == k) {
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }
        }
        return max;
    }
}
