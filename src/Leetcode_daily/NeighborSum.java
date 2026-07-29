package Leetcode_daily;

import java.util.HashMap;

public class NeighborSum {
    HashMap<Integer,Integer> neighbourSum;
    HashMap<Integer,Integer> diagonalSum;
    int[] nx = {1,-1,0,0};
    int[] ny = {0,0,1,-1};

    int[] dx = {-1,-1,1,1};
    int[] dy = {-1,1,-1,1};
    public NeighborSum(int[][] grid) {
        int n = grid.length;
        this.neighbourSum = new HashMap<>();
        this.diagonalSum = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //Neighbor Element
                int key = grid[i][j];

                int adjSum = 0;
                for(int k = 0; k < 4; k++){
                    int ni = i + nx[k];
                    int nj = j + ny[k];

                    if(ni >= 0 && ni < n && nj >= 0 && nj < n){
                        adjSum += grid[ni][nj];
                    }
                }
                neighbourSum.put(key,adjSum);

                //Diagonal Element
                int diaSum = 0;
                for(int k = 0; k < 4; k++){
                    int di = i + dx[k];
                    int dj = j + dy[k];

                    if(di >= 0 && di < n && dj >= 0 && dj < n){
                        diaSum += grid[di][dj];
                    }
                }
                diagonalSum.put(key,diaSum);
            }
        }
    }

    public int adjacentSum(int value) {
        return neighbourSum.get(value);
    }

    public int diagonalSum(int value) {
        return diagonalSum.get(value);
    }
}
