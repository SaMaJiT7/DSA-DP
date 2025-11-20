package knapsack;

import java.util.Arrays;

public class max_energy {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] t = new int[n];
        Arrays.fill(t,0);
        int max = Integer.MIN_VALUE;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return energy[0];
        }
        for(int i = n-1; i >= 0; i--){
            if(i+k >= n) {
                t[i] = energy[i];
            }
            else{
                t[i] = t[i + k] + energy[i];
            }
            max = Math.max(max,t[i]);
        }
        return max;
    }
}
