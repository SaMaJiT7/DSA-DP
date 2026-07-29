package HEAP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            nums[i][0] = capital[i];
            nums[i][1] = profits[i];
        }
        Arrays.sort(nums,(a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));
        int i = 0;
        while(k > 0){

            while(i < n && nums[i][0] < w){
                maxheap.add(new int[]{nums[i][0],nums[i][1]});  // storing like capital , profit.
            }

            if(maxheap.isEmpty()){
                break;
            }

            w += maxheap.poll()[1];
            k--;
        }

        return w;
    }
}
