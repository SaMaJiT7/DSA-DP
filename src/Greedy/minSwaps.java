package Greedy;

public class minSwaps {
//    public int minSwaps(int[][] grid) {
//        int n = grid.length;
//        int minswap = 0;  // accumulate swaps
//        int[] trailingzeroes = new int[n];
//
//        for(int i = 0; i < n; i++){
//            int z = 0;
//            for(int j = n-1; j >= 0; j--){
//                if(grid[i][j] == 0) z++;
//                else break;
//            }
//            trailingzeroes[i] = z;
//        }
//
//        for(int i = 0; i < n; i++){
//            int j = i;
//            while(j < n && trailingzeroes[j] < n - 1 - i) j++;  // find first valid row
//            if(j == n) return -1;  // impossible
//            minswap += j - i;
//
//            // move row j up to position i
//            int temp = trailingzeroes[j];
//            for(int k = j; k > i; k--){
//                trailingzeroes[k] = trailingzeroes[k-1];
//            }
//            trailingzeroes[i] = temp;
//        }
//
//        return minswap;
//    }
public int minSwaps(int[][] grid) {
    int n = grid.length;
    int minswap = 0;  // accumulate swaps
    int[] trailingzeroes = new int[n];

    for (int i = 0; i < n; i++) {
        int z = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (grid[i][j] == 0) z++;
            else break;
        }
        trailingzeroes[i] = z;
    }
    for(int i = 0; i < n; i++){
        int need = n - i - 1;
        int j = i;
        while (j < n && trailingzeroes[j] < need) j++;
        if(j == n) return -1;
        minswap += j - i;


        while(j > i) {
            int temp = trailingzeroes[j];
            trailingzeroes[j] = trailingzeroes[j-1];
            trailingzeroes[j-1] = temp;
            j--;
        }
    }
    return minswap;
}
}
