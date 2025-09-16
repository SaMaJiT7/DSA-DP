package Hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class vowelscheck {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        HashMap<String, String> caseMap = new HashMap<>();   // Case-insensitive
        HashMap<String, String> vowelMap = new HashMap<>();

        for(String s : wordlist){
            map.put(s,s);
            String lower = s.toLowerCase();
            caseMap.putIfAbsent(lower,s);
            String mask = getVowelMask(s);
            vowelMap.putIfAbsent(mask,s);
        }

        for(String s1 : queries){
            if(map.containsKey(s1)){
                ans.add(map.get(s1));
                continue;
            }
            if(caseMap.containsKey(s1.toLowerCase())){
                ans.add(caseMap.get(s1.toLowerCase()));
                continue;
            }
            if(vowelMap.containsKey(getVowelMask(s1))){
                ans.add(vowelMap.get(getVowelMask(s1)));
            }
            else {
                ans.add("");
            }
        }
        return ans.toArray(new String[0]);
    }
    private static String getVowelMask(String word) {
        StringBuilder mask = new StringBuilder();
        word = word.toLowerCase();  // Normalize case
        for (char c : word.toCharArray()) {  // Loop to check each char
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mask.append('*');  // Replace vowel
            } else {
                mask.append(c);  // Keep consonant
            }
        }
        return mask.toString();
    }
}
