package HEAP;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class closet_point {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> MaxHeap = new PriorityQueue<>();

        for(int i = 0; i < points.length;i++){
            int key = (int) (Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            MaxHeap.add(new Pair(key, points[i]));

            if(MaxHeap.size() > k){
                MaxHeap.poll();
            }
        }
        ArrayList<int[]> result = new ArrayList<>();
        while(MaxHeap.size() != 0){
            Pair p = MaxHeap.poll();
            result.add(p.points);
        }
        int[][] Answer = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            Answer[i] = result.get(i);  // Reference the existing int[] (shallow copy)
            // If deep copy needed (rare): arrayResult[i] = result.get(i).clone();
        }
        return Answer;
    }

    class Pair implements Comparable<Pair>{
        int key;
        int[] points;

        public Pair(int key,int[] point){
            this.key = key;
            this.points = point;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.key != other.key) {
                return Integer.compare(other.key,this.key); // Max-heap on frequency
            }
            return Integer.compare(this.key,other.key);       // tie-break on value
        }

    }
}
