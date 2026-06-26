package Leetcode_daily;

public class findAltitude {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int large = 0;
        int n = gain.length;
        for(int i = 0; i < n; i++){
            altitude += gain[i];
            large = Math.max(large,altitude);
        }
        return large;
    }
}
