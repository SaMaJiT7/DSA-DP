package LC_QUestion;

public class neg_num_grid {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] < 0){
                    count++;
                }
            }
        }
        return count;
    }
    public int countNegatives0(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int[] row : grid) {
            int s = 0 , e = m-1;
            while(s <= e) {
                int mid = s + (e - s) / 2;
                if (row[mid] < 0) {
                    e = mid - 1;
                }
                else{
                    s = mid + 1;
                }
            }
            count += m - s;
        }
        return count;
    }
}
