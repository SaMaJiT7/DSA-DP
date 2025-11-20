package Sliding_Window;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class anagram_find {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int n = s.length();
        int m = p.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int count = m;

        while (j < n) {
            char chid = s.charAt(j);

            if (map.containsKey(chid)) {
                if (map.get(chid) > 0) {
                    count--;
                }
                map.put(chid, map.get(chid) - 1);
            }

            if (j - i + 1  > m) {
                char prevch = s.charAt(i);
                if (map.containsKey(prevch)) {
                    if (map.get(prevch) >= 0) count++;
                    map.put(prevch, map.get(prevch) + 1);
                }
                i++;
            }
            if (count == 0) {
                result.add(i);
            }
            j++;
        }
        return result;
    }
}
