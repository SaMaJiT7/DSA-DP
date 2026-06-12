package Hashmap;

import LC_QUestion.INT_TO_ROMAN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class sort_vowels {
    public String sortVowels(String s) {
        int n = s.length();
        HashMap<Character,Integer> freqMap = new HashMap<>();
        HashMap<Character,Integer> firstOccurrence = new HashMap<>();
        List<Character> freqlist = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char CH = s.charAt(i);
            if((CH == 'a')|| (CH == 'e' )||(CH == 'i') || (CH == 'o') || (CH == 'u')) {
                freqMap.put(CH, freqMap.getOrDefault(CH, 0) + 1);
                if (!firstOccurrence.containsKey(CH)) {
                    firstOccurrence.put(CH, i);
                }
            }
        }


        freqlist.addAll(freqMap.keySet());

        freqlist.sort((a,b) -> {
            int res = Integer.compare(freqMap.get(b),freqMap.get(a));

            if(res == 0){
                return Integer.compare(firstOccurrence.get(a),firstOccurrence.get(b));
            }

            return res;
        });
        StringBuilder seq = new StringBuilder();
        for(char c : freqlist){
            int times = freqMap.get(c);
            for (int t = 0; t < times; t++) {
                seq.append(c);
            }
        }
        char[] ans = s.toCharArray();
        char[] sequence = seq.toString().toCharArray();
        int j = 0;
        for(int i = 0; i < ans.length; i++){
            char CH = ans[i];
            if((CH == 'a')|| (CH == 'e' )||(CH == 'i') || (CH == 'o') || (CH == 'u')){
                ans[i] = sequence[j++];
            }
        }

        return new String(ans);
    }
}
