package Sliding_Window;

import java.util.HashMap;

public class count_of_anagrams {
    int search(String pat, String txt) {
        char[] s = txt.toCharArray();
        int n = txt.length();
        int k = pat.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : pat.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();

        int i =0;
        int j = 0;
        int ans = 0;
        while(j < n){
            if (map.containsKey(s[j])) {
                map.put(s[j], map.get(s[j]) - 1);
                if (map.get(s[j]) == 0) {
                    count--;
                }
            }

            if(j-i+1 < k){
                j++;
            }
            else if (j-i+1 ==k) {
                if (count == 0) ans++;


                if (map.containsKey(s[i])) {
                    if (map.get(s[i]) == 0) {
                        count++;
                    }
                    map.put(s[i], map.get(s[i]) + 1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
