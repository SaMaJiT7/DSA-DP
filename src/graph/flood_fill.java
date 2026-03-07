package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class flood_fill {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int pixel = image[sr][sc];
        if(pixel == color) return image;
        image[sr][sc] = color;
        queue.add(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int r = p[0];
            int c = p[1];
            for(int i = 0; i < 4; i++){
                int newR = r + dx[i];
                int newC = c + dy[i];
                if(newR < n && newR >= 0 && newC < m && newC >=0) {
                    if (image[newR][newC] == pixel) {
                        image[newR][newC] = color;
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
        }
        return image;
    }
}
