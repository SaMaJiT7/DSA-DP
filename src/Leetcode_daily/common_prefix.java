package Leetcode_daily;

import java.util.HashSet;

public class common_prefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> prefixs = new HashSet<>();
        int n = arr1.length;
        int m = arr2.length;
        for(int i = 0; i < n; i++){
            int val = arr1[i];
            String s = String.valueOf(val);
            for(int k = 1; k <= s.length(); k++){
                String prefix = s.substring(0,k);
                prefixs.add(prefix);
            }
        }

        int ans = 0;
        for(int i = 0; i < m; i++){
            int val = arr2[i];
            String s = String.valueOf(val);
            for(int k = 1; k <= s.length(); k++){
                String prefix = s.substring(0,k);
                if(prefixs.contains(prefix)){
                    ans = Math.max(ans,prefix.length());
                }
            }
        }
        return ans;
    }
}
