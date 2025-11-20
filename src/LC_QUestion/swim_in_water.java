package LC_QUestion;

public class swim_in_water {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    int n;
    int m;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int l = grid[0][0];
        int r = n*n - 1;

        int result  = 0;


        while(l <= r){
            int mid = l + (r-l)/2;

            boolean[][] visited = new boolean[n][m];

            if(possibletoReach(grid,0,0,mid,visited)){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return result;
    }

    boolean possibletoReach(int[][] grid,int i, int j, int t,boolean[][] visited){
        if(i < 0 || i >= n || j < 0 || j >= n || visited[i][j] == true || grid[i][j] > t){
            return false;
        }

        visited[i][j] = true;

        if(i == n-1 && j == n-1){
            return true;
        }

        for(int k = 0; k < 4; k++){
            int i_ = i + dx[k];
            int j_ = j + dy[k];

            if(possibletoReach(grid,i_,j_,t,visited)){
                return true;
            }
        }
        return false;
    }
}
