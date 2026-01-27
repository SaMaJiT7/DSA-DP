package LC_QUestion;

public class maxsidelength {
//    public int maxSideLength(int[][] mat, int threshold) {
//        int n = mat.length;
//        int m = mat[0].length;
//        int[][] prefixsum = new int[n][m];
//
//        // 1. Prefix Sum Construction (Same as before)
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                prefixsum[i][j] = mat[i][j]
//                        + (i > 0 ? prefixsum[i - 1][j] : 0)
//                        + (j > 0 ? prefixsum[i][j - 1] : 0)
//                        - (i > 0 && j > 0 ? prefixsum[i - 1][j - 1] : 0);
//            }
//        }
//
//        int bestside = 0;
//
//        // 2. Iterate treating (i, j) as the BOTTOM-RIGHT corner
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//
//                // We want to test a square size of (bestside + 1)
//                int targetLen = bestside + 1;
//
//                // Logic: Can a square of size 'targetLen' END at (i, j)?
//                // We need enough room "above" and "to the left"
//                if (i - targetLen + 1 >= 0 && j - targetLen + 1 >= 0) {
//
//                    int r2 = i;
//                    int c2 = j;
//                    int r1 = i - targetLen + 1;
//                    int c1 = j - targetLen + 1;
//
//                    int val = findsum(prefixsum, r1, c1, r2, c2);
//
//                    if (val <= threshold) {
//                        bestside++;
//                    }
//                }
//            }
//        }
//        return bestside;
//    }
//
//    public int findsum(int[][] prefixsum, int r1, int c1, int r2, int c2) {
//        int ans = prefixsum[r2][c2];
//        if (r1 > 0) ans -= prefixsum[r1 - 1][c2];
//        if (c1 > 0) ans -= prefixsum[r2][c1 - 1];
//        if (r1 > 0 && c1 > 0) ans += prefixsum[r1 - 1][c1 - 1];
//        return ans;
//    }
public int maxSideLength(int[][] mat, int threshold) {
    int n = mat.length;
    int m = mat[0].length;
    int[][] prefixsum = new int[n][m];

        // 1. Prefix Sum Construction (Same as before)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixsum[i][j] = mat[i][j]
                        + (i > 0 ? prefixsum[i - 1][j] : 0)
                        + (j > 0 ? prefixsum[i][j - 1] : 0)
                        - (i > 0 && j > 0 ? prefixsum[i - 1][j - 1] : 0);
            }
        }

        int low = 1;
        int high = Math.min(n,m);
        int result = -1;
        while(low <= high){
            int mid = low +(high-low)/2;

            if(check(mid,prefixsum,threshold)){
                result = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return result;
}
public boolean check(int side,int[][] prefixsum,int treshold){
    int n = prefixsum.length;
    int m = prefixsum[0].length;
    for(int i = 0; i + side - 1< n; i++){
        for(int j = 0; j + side - 1 < m; j++){
            int r2 = i + side - 1;
            int c2 = j + side - 1;

            if(findsum(prefixsum,i,j,r2,c2) <= treshold){
                return true;
            }
        }
    }
    return false;
}
public int findsum(int[][] prefixsum, int r1, int c1, int r2, int c2) {
        int ans = prefixsum[r2][c2];
        if (r1 > 0) ans -= prefixsum[r1 - 1][c2];
        if (c1 > 0) ans -= prefixsum[r2][c1 - 1];
        if (r1 > 0 && c1 > 0) ans += prefixsum[r1 - 1][c1 - 1];
        return ans;
    }
}
