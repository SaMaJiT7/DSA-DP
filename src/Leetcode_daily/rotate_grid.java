package Leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class rotate_grid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m,n)/2;
        for(int layer = 0; layer < layers; layer++){
            List<Integer> elements = new ArrayList<>();
            int top = layer;
            int right = n-1-layer;
            int left = layer;
            int bottom = m-1-layer;
            //TOP Traversal
            for(int i = left; i < right; i++){
                elements.add(grid[top][i]);
            }
            //Right Traversal
            for(int i = top; i < bottom; i++){
                elements.add(grid[i][right]);
            }
            //Bottom Traversal
            for(int i = right; i > left; i--){
                elements.add(grid[bottom][i]);
            }
            //Left Traversal
            for(int i = bottom; i > top; i--){
                elements.add(grid[i][left]);
            }

            int len = elements.size();
            int shift = k % len;
            List<Integer> rotated = new ArrayList<>();
            for(int i = 0; i < len; i++){
                rotated.add(elements.get((i+shift)%len));
            }

            int l = 0;
            //TOP Traversal
            for(int i = left; i < right; i++){
                grid[top][i] = rotated.get(l++);
            }
            //Right Traversal
            for(int i = top; i < bottom; i++){
                grid[i][right] = rotated.get(l++);
            }
            //Bottom Traversal
            for(int i = right; i > left; i--){
                grid[bottom][i] = rotated.get(l++);
            }
            //Left Traversal
            for(int i = bottom; i > top; i--){
                grid[i][left] = rotated.get(l++);
            }
        }
        return grid;
    }
}
