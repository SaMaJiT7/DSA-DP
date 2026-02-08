package LC_QUestion;

import java.util.Arrays;

public class Hindex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int hindex = Integer.MIN_VALUE;
        Arrays.sort(citations);
        int[] h = new int[n];
        for(int i = 0; i < n; i++){
            h[i] = Math.min(citations[i],n-i);
        }
        for(int i = 0; i < n; i++){
            hindex = Math.max(hindex,h[i]);
        }
        return hindex;
    }
}
