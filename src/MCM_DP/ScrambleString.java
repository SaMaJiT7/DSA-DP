package MCM_DP;

import java.util.Arrays;
import java.util.HashMap;

public class ScrambleString {
    HashMap<String , Boolean> mp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();




        String key =  s1 +'_'+ s2;

        if(mp.containsKey(key)){
            return mp.get(key);
        }

        int[] count = new int[600];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                mp.put(key,false);
                return false;
            }
        }

        for (int i = 1; i < n; i++) {

            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i,n), s2.substring(i,n))) {
                mp.put(key,true);
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                mp.put(key,true);
                return true;
            }
        }

        mp.put(key,false);
        return false;
    }
}

