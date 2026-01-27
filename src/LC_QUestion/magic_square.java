package LC_QUestion;

public class magic_square {
//    public int largestMagicSquare(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] rowsum = new int[n][m];
//        int[][] colsum = new int[n][m];
//
//
//        for(int i = 0; i < n; i++){
//            rowsum[i][0] = grid[i][0];
//            for(int j = 1; j < m; j++){
//                rowsum[i][j] = rowsum[i][j-1] + grid[i][j];
//            }
//        }
//
//        // Optimized colsum calculation (Row-Major traversal)
//        for(int j = 0; j < m; j++) {
//            colsum[0][j] = grid[0][j]; // Initialize first row
//        }
//
//        for(int i = 1; i < n; i++){      // Iterate rows
//            for(int j = 0; j < m; j++){  // Iterate columns (contiguous memory)
//                colsum[i][j] = colsum[i-1][j] + grid[i][j];
//            }
//        }
//
//        int ans = isMagicSquare(rowsum,colsum,n,m,grid);
//        return ans;
//
//    }
//    public int isMagicSquare(int[][] rowsum,int[][] colsum,int n,int m, int[][] grid){
//        for(int side = Math.min(n,m); side >= 2; side--){
//            for(int i = 0; i+side-1 < n; i++){
//                for(int j = 0; j+side-1 < m; j++){
//                    int targetsum = rowsum[i][j+side-1] - (j > 0 ? rowsum[i][j-1] : 0);
//
//                    //all rows
//                    boolean issame = true;
//                    for(int r = i+1; r < side+i; r++){
//                        int sum = rowsum[r][j+side-1] -( j > 0 ? rowsum[r][j-1] : 0 );
//                        if(sum != targetsum){
//                            issame = false;
//                            break;
//                        }
//                    }
//                    if(issame == false){ continue;}
//                    //all cols
//                    else{
//                        for(int c = j; c < j+side; c++){
//                            int sum = colsum[i+side-1][c] - ( i > 0 ? colsum[i-1][c] : 0 );
//                            if(sum != targetsum){
//                                issame = false;
//                                break;
//                            }
//                        }
//                    }
//
//                    if(issame == false){ continue;}
//                    else{
//                        int dia = 0,antidia = 0;
//                        for(int k = 0; k < side; k++){
//                            dia += grid[i+k][j+k];
//                            antidia += grid[i+k][j+side-1-k];
//                        }
//                        if(dia == targetsum && antidia == targetsum){
//                            return  side;
//                        }
//                    }
//                }
//            }
//        }
//        return 1;
//    }
public int largestMagicSquare(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] rowsum = new int[n][m];
    int[][] colsum = new int[n][m];
    int[][] dia = new int[n][m];
    int[][] antidia = new int[n][m];



    for(int i = 0; i < n; i++){
        rowsum[i][0] = grid[i][0];
        for(int j = 1; j < m; j++){
            rowsum[i][j] = rowsum[i][j-1] + grid[i][j];
        }
    }

    // Optimized colsum calculation (Row-Major traversal)
    for(int j = 0; j < m; j++) {
        colsum[0][j] = grid[0][j]; // Initialize first row
    }

    for(int i = 1; i < n; i++){      // Iterate rows
        for(int j = 0; j < m; j++){  // Iterate columns (contiguous memory)
            colsum[i][j] = colsum[i-1][j] + grid[i][j];
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            dia[i][j] = grid[i][j] + (i > 0 && j > 0 ? dia[i-1][j-1] : 0);

            antidia[i][j] = grid[i][j] + (i > 0 && j + 1 < m ? antidia[i - 1][j + 1] : 0);
        }
    }
    for(int side = Math.min(n,m); side >= 2; side--){
        for(int i = 0; i+side-1 < n; i++) {
            for (int j = 0; j + side - 1 < m; j++) {
                if (isMagicSquare(rowsum, colsum, i, j, dia,antidia,grid,side)){
                    return side;
                };
            }
        }
    }
    return 1;
}
        public boolean isMagicSquare(int[][] rowsum,int[][] colsum,int r,int c, int[][] diag,int[][] anti, int[][] grid,int side){

            // Calculate the target sum from the first row
            int val1 = rowsum[r][c + side - 1];
            int val2 = (c > 0 ? rowsum[r][c - 1] : 0);
            int target = val1 - val2;

            // OPTIMIZATION: Check Diagonals FIRST (O(1) check)
            // Main Diagonal Sum: End(r+k, c+k) - Prev(r-1, c-1)
            int dSum = diag[r + side - 1][c + side - 1] - (r > 0 && c > 0 ? diag[r - 1][c - 1] : 0);
            if (dSum != target) return false;

            // Anti Diagonal Sum: End(r+k, c) - Prev(r-1, c+k+1)
            // Note: Anti-diag ends at bottom-left (r+side-1, c)
            int aSum = anti[r + side - 1][c] - (r > 0 && c + side < anti[0].length ? anti[r - 1][c + side] : 0);
            if (aSum != target) return false;

            // Check Rows (skip first row as it is the target)
            for (int i = r + 1; i < r + side; i++) {
                int rSum = rowsum[i][c + side - 1] - (c > 0 ? rowsum[i][c - 1] : 0);
                if (rSum != target) return false;
            }

            // Check Columns
            for (int j = c; j < c + side; j++) {
                int cSum = colsum[r + side - 1][j] - (r > 0 ? colsum[r - 1][j] : 0);
                if (cSum != target) return false;
            }

            return true;
    }
}
