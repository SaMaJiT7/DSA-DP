package Sliding_Window;

import java.util.HashMap;

public class minimum_window_substring {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        int size = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int f = 0; f < t.length(); f++){
            map.put(t.charAt(f), map.getOrDefault(t.charAt(f),0)+1);
        }
        int count = map.size();

        if(size < t.length()){
            return "";
        }

        while(j < size){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);

                if(map.get(s.charAt(j)) == 0){
                    count = count - 1;
                }
            }
            j++;
            while (count == 0) {

                if(j - i < min) {
                    min = j - i;
                    ans = s.substring(i, j);
                }

                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) > 0) {
                        count = count + 1;
                    }
                }
                i++;
                }
            }
        return  ans;
    }
}
