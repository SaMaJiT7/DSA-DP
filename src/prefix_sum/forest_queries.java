package prefix_sum;

import java.util.Scanner;

public class forest_queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        char[][] forest = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            forest[i] = line.toCharArray();
        }


        int[][] prefix_2D = new int[n+1][n+1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n ; j++){
                int treeCount = (forest[i-1][j-1] == '*') ? 1 : 0;

                prefix_2D[i][j] = treeCount +
                        prefix_2D[i-1][j] +
                        prefix_2D[i][j-1] -
                        prefix_2D[i-1][j-1];
            }
        }


        while(q-- > 0){
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();
            int ans = prefix_2D[y2][x2] - prefix_2D[y1-1][x2] - prefix_2D[y2][x1-1] + prefix_2D[y1-1][x1-1];
            System.out.println(ans+" ");
        }
    }
}
