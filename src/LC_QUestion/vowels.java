package LC_QUestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class vowels {
    public int maxFreqSum(String s) {
        int maxvowel = 0;
        int maxconsonant = 0;
        char[] vowels = {'a','e','i','o','u'};
        HashMap<Character,Integer> map= new HashMap<>();
        HashSet<Character> vowelslist = new HashSet<>();
        vowelslist.add('a');
        vowelslist.add('e');
        vowelslist.add('i');
        vowelslist.add('o');
        vowelslist.add('u');

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            if(vowelslist.contains(ch)){
                maxvowel = Math.max(maxvowel,entry.getValue());
            }
            else{
                maxconsonant = Math.max(maxconsonant,entry.getValue());
            }
        }
        return maxvowel + maxconsonant;
    }
}
