package Adhoc_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class maxvalue {
    static int mod = (int) 1000000007;
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        List<String> segment = new ArrayList<>();
        long ans = 0;
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < nums1[i]; j++) sb.append(1);
            for(int j = 0; j < nums0[i]; j++) sb.append(0);

            segment.add(sb.toString());
        }

        Collections.sort(segment,(a,b) -> (b+a).compareTo(a+b));

        for(int i = 0; i < segment.size(); i++){
            String s = segment.get(i);
            for(char ch : s.toCharArray()){
                ans = (ans * 2 + (ch - '0')) % mod;
            }
        }
        return (int)ans;
    }
}
