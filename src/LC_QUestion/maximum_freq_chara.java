package LC_QUestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class maximum_freq_chara {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> charcount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charcount.put(ch, charcount.getOrDefault(ch, 0) + 1);
        }


        HashMap<Integer, StringBuilder> groups = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : charcount.entrySet()) {
            int freq = entry.getValue();
            groups.putIfAbsent(freq, new StringBuilder());
            groups.get(freq).append(entry.getKey());
        }
        String result = "";
        int maxGroupSize = 0;

        for (Map.Entry<Integer, StringBuilder> entry : groups.entrySet()) {
            String group = entry.getValue().toString();
            if (group.length() > maxGroupSize) {
                maxGroupSize = group.length();
                result = group;
            }
        }
        return result;
    }
}
