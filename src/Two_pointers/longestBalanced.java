package Two_pointers;

import java.util.HashMap;

public class longestBalanced {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxL = 0;

        // case 1: all same characters
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                maxL = Math.max(maxL, count);
                count = 1;
            }
        }
        maxL = Math.max(maxL, count);

        // case 2: two-character balance
        maxL = Math.max(maxL, helper(s, 'a', 'b'));
        maxL = Math.max(maxL, helper(s, 'b', 'c'));
        maxL = Math.max(maxL, helper(s, 'a', 'c'));

        // case 3: a,b,c balanced
        int countA = 0, countB = 0, countC = 0;
        HashMap<Long, Integer> diffmap = new HashMap<>();
        diffmap.put(0L, -1);  // (0,0) base case

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else if (ch == 'c') countC++;

            int diffAB = countA - countB;
            int diffAC = countA - countC;

            long key = (((long) diffAB) << 32) | (diffAC & 0xffffffffL);

            if (diffmap.containsKey(key)) {
                maxL = Math.max(maxL, i - diffmap.get(key));
            } else {
                diffmap.put(key, i);
            }
        }
        return maxL;
    }

    public int helper(String s, char ch1, char ch2) {
        int n = s.length();
        int maxl = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int count1 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch != ch1 && ch != ch2) {
                map.clear();
                map.put(0, i);
                count1 = 0;
                count2 = 0;
                continue;
            }

            if (ch == ch1) count1++;
            else count2++;

            int diff = count1 - count2;

            if (map.containsKey(diff)) {
                maxl = Math.max(maxl, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return maxl;
    }


}
