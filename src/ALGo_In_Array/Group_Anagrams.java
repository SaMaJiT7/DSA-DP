package ALGo_In_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String word = strs[i];
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String newword = new String(arr);
            map.computeIfAbsent(newword,k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
