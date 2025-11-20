package LC_QUestion;

import java.util.Arrays;

public class Not_gaurded {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        boolean[][] guarded = new boolean[m][n];

        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = 1;

        for (int[] g : guards) {
            int row = g[0];
            int col = g[1];

            // UP
            for (int r = row - 1; r >= 0; r--) {
                if (grid[r][col] == 1) break;
                guarded[r][col] = true;
            }

            // DOWN
            for (int r = row + 1; r < m; r++) {
                if (grid[r][col] == 1) break;
                guarded[r][col] = true;
            }

            // LEFT
            for (int c = col - 1; c >= 0; c--) {
                if (grid[row][c] == 1) break;
                guarded[row][c] = true;
            }

            // RIGHT
            for (int c = col + 1; c < n; c++) {
                if (grid[row][c] == 1) break;
                guarded[row][c] = true;
            }
        }

        int covered = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // any cell that is a wall, guard, or guarded
                if (grid[i][j] == 1 || guarded[i][j]) {
                    covered++;
                }
            }
        }

        // unguarded = total - covered
        return (m * n) - covered;
    }
}
