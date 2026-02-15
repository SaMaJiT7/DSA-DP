package Greedy;

import java.util.Arrays;

public class profit_assign_work {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        int maxprofit = 0;
        int ans= 0;
        int[][] jobs = new int[n][2];
        for(int i = 0; i < n; i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        int i = 0;
        int j = 0;
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(worker);

        while(j < m) {
            while (i < n && jobs[i][0] <= worker[j]) {
                maxprofit = Math.max(maxprofit, jobs[i][1]);
                i++;
            }
            ans = ans + maxprofit;
            j = j + 1;
        }
        return ans;
    }
}
