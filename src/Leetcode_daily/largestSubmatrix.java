package Leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestSubmatrix {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<int[]> prevheight = new ArrayList<>(); // {height,column}
        int maxarea = 0;
//        Arrays.fill(height,0);
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                if(matrix[i][j] == 1) height[j] += 1;
//                else height[j] = 0;
//            }
//            int[] temp = height.clone();
//            Arrays.sort(temp);
//            for(int k = 0; k < temp.length; k++){
//                int area = temp[k] * (m-k);
//                maxarea = Math.max(area,maxarea);
//            }
//        }
//        return maxarea;

         for(int row = 0; row < n; row++){
             List<int[]> currheight = new ArrayList<>();
             boolean[] visited = new boolean[m];
             Arrays.fill(visited,false);
             for(int[] pair : prevheight){
                 int height = pair[0];
                 int col = pair[1];
                 if(matrix[row][col] == 1){
                     currheight.add(new int[]{height+1,col});
                     visited[col] = true;
                 }
             }
             for(int col = 0; col < m; col++){
                 if(!visited[col] && matrix[row][col] == 1){
                     currheight.add(new int[]{1,col});
                 }
             }
             for(int i = 0; i < currheight.size(); i++){
                 int H = currheight.get(i)[0];
                 int B = i+1;

                 maxarea = Math.max(maxarea,H*B);
             }
             prevheight = currheight;
         }
         return maxarea;
    }
}
