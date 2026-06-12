package Leetcode_daily;

import java.util.HashMap;

public class CanPartition_Hard {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        HashMap<Integer, Integer> BottomMap = new HashMap<>();
        HashMap<Integer, Integer> RightMap = new HashMap<>();
        long Totalsum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Totalsum += grid[i][j];
                BottomMap.put(grid[i][j], BottomMap.getOrDefault(grid[i][j], 0) + 1);
                RightMap.put(grid[i][j], RightMap.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        // Horizontal CHECK
        long Hsum = 0;
        HashMap<Integer, Integer> TopMap = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Hsum += grid[i][j];
                TopMap.put(grid[i][j], TopMap.getOrDefault(grid[i][j], 0) + 1);

                BottomMap.put(grid[i][j], BottomMap.get(grid[i][j]) - 1);
                if (BottomMap.get(grid[i][j]) == 0) {
                    BottomMap.remove(grid[i][j]);
                }
            }

            long other = Totalsum - Hsum;
            if (Hsum == other) return true;

            long diff = Math.abs(Hsum - other);
            int rows = i + 1;

            // Top heavier
            if (Hsum > other) {
                if (diff <= 100000 && TopMap.containsKey((int) diff)) {
                    if (rows > 1 && m > 1) {
                        return true;
                    }
                    if (rows * m > 1) {
                        if (rows == 1) {
                            if (grid[0][0] == diff || grid[0][m - 1] == diff) {
                                return true;
                            }
                        } else { // m == 1
                            if (grid[0][0] == diff || grid[rows - 1][0] == diff) {
                                return true;
                            }
                        }
                    }
                }
            }
            // Bottom heavier
            else {
                if (diff <= 100000 && BottomMap.containsKey((int) diff)) {
                    int bottomRows = n - (i + 1);

                    if (bottomRows > 1 && m > 1) {
                        return true;
                    }
                    if (bottomRows * m > 1) {
                        if (bottomRows == 1) {
                            if (grid[i + 1][0] == diff || grid[i + 1][m - 1] == diff) {
                                return true;
                            }
                        } else { // m == 1
                            if (grid[i + 1][0] == diff || grid[n - 1][0] == diff) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        // Vertical CHECK
        long Vsum = 0;
        HashMap<Integer, Integer> LeftMap = new HashMap<>();

        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                Vsum += grid[i][j];
                LeftMap.put(grid[i][j], LeftMap.getOrDefault(grid[i][j], 0) + 1);

                RightMap.put(grid[i][j], RightMap.get(grid[i][j]) - 1);
                if (RightMap.get(grid[i][j]) == 0) {
                    RightMap.remove(grid[i][j]);
                }
            }

            long other = Totalsum - Vsum;
            if (Vsum == other) return true;

            long diff = Math.abs(Vsum - other);
            int cols = j + 1;

            // Left heavier
            if (Vsum > other) {
                if (diff <= 100000 && LeftMap.containsKey((int) diff)) {
                    if (cols > 1 && n > 1) {
                        return true;
                    }
                    if (cols * n > 1) {
                        if (cols == 1) {
                            if (grid[0][0] == diff || grid[n - 1][0] == diff) {
                                return true;
                            }
                        } else { // n == 1
                            if (grid[0][0] == diff || grid[0][cols - 1] == diff) {
                                return true;
                            }
                        }
                    }
                }
            }
            // Right heavier
            else {
                if (diff <= 100000 && RightMap.containsKey((int) diff)) {
                    int rightCols = m - (j + 1);

                    if (rightCols > 1 && n > 1) {
                        return true;
                    }
                    if (n * rightCols > 1) {
                        if (rightCols == 1) {
                            if (grid[0][j + 1] == diff || grid[n - 1][j + 1] == diff) {
                                return true;
                            }
                        } else { // n == 1
                            if (grid[0][j + 1] == diff || grid[0][m - 1] == diff) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
