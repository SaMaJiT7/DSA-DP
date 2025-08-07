package Sliding_Window;

import java.util.HashMap;

public class unique_longest_substring {
//    public int longest_substring(String s){
//        int i = 0;
//        int j = 0;
//        int n = s.length();
//        int max = -1;
//        HashMap<Character,Integer> map = new HashMap<>();
//        while(j < n){
//            map.put(s.charAt(j),map.getOrDefault(s.charAt(j), 0) + 1);
//
//            if (map.get(s.charAt(j)) > 1) {
//                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
//                if (map.get(s.charAt(i)) == 0) {
//                    map.remove(s.charAt(i));
//                }
//                i++;
//            }
//
//            max = Math.max(max, j - i + 1);
//            j++;
//        }
//        return max;
//    }
public int longest_substring(String s){
    int i = 0;
    int j = 0;
    int n = s.length();
    int max = -1;
    HashMap<Character,Integer> map = new HashMap<>();
    while(j < n){
        map.put(s.charAt(j),map.getOrDefault(s.charAt(j), 0) + 1);

        if(map.size() == j-i+1){
            max = Math.max(max, j - i + 1);
            j++;
        }
        if (map.size() < j-i+1){
            while(map.size() < j-i+1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
        }
        j++;
    }
    return max;
}
}
