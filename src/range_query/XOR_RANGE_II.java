package range_query;

import jdk.jshell.execution.JdiInitiator;

import java.util.*;

public class XOR_RANGE_II {
    static int mod = (int) 1000000007;
    long[] diff;
    int n;
    int blocksize;
    HashMap<Integer, List<int[]>> map;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        this.n = nums.length;
        this.blocksize = (int) Math.ceil(Math.sqrt(n));
        this.diff = new long[n];
        this.map = new HashMap<>();
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            if(k >= blocksize) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)(((long) nums[i] * v) % mod);
                }
            }
            else{
                map.computeIfAbsent(k, key -> new ArrayList<>()).add(new int[]{l, r, v});
            }
        }

        for(Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
            int k = entry.getKey();
            List<int[]> list = entry.getValue();
            Arrays.fill(diff,1);
            for (int[] val : list) {
                int l = val[0];
                int r = val[1];
                int v = val[2];
                int step = (r - l) / k;
                int next = l + (step + 1) * k;
                diff[l] = (diff[l] * v) % mod;
                if (next < n) {
                    diff[next] = (diff[next] * pow(v, mod - 2)) % mod;
                }
            }
            for(int i = 0; i < n; i++){
                if(i - k >= 0){
                    diff[i] = (diff[i] * diff[i - k]) % mod;
                }
            }
            //applying to nums
            for(int i = 0; i < n; i++){
                nums[i] = (int)(((long) nums[i] * diff[i]) % mod);
            }
        }
        int result = 0;
        for(int num : nums){
            result  = result ^ num;
        }
        return result;
    }
    public long pow(long a, long b){
        long res = 1;
        a %= mod;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b /= 2;
        }
        return res;
    }
}
