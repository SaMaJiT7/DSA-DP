package Hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class flower_game {
    public char repeatedCharacter(String s) {
        HashSet<Character> map = new HashSet<>();
        char[] s1 = s.toCharArray();

        for(char c : s1){
            if(!map.add(c)){
                return c;
            }
        }
        return 'a';
    }
}
