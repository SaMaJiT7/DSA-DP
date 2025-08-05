package Hashmap;

import java.util.HashMap;

public class roman_Integer {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = 0;
        char[] s1 = s.toCharArray();

        for(int i = 0; i < s1.length; i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            }
            else{
                ans = ans + map.get(s1[i]);
            }
        }
        return ans;
    }
}
