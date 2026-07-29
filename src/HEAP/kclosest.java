package HEAP;

import java.util.PriorityQueue;

public class kclosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b[2],a[2]));
        int n = points.length;
        for(int i = 0; i < n; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;

            maxheap.add(new int[]{x,y,dist});

            while(maxheap.size() > k){
                maxheap.poll();
            }
        }
        int[][] answer = new int[maxheap.size()][2];
        int i = 0;
        while(!maxheap.isEmpty()){
            int[] val = maxheap.poll();
            answer[i][0] = val[0];
            answer[i][1] = val[1];
            i++;
        }
        return answer;
    }
}
