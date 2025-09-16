import java.util.*;

public class matrix_diagonal {
    public int[][] sortMatrix(int[][] grid) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                int key = row - col;
                map.putIfAbsent(key,new ArrayList<>());
                map.get(key).add(grid[row][col]);
            }
        }

        for(int key : map.keySet()){
            List<Integer> diag  = map.get(key);
            if(key > 0){
                Collections.sort(diag,Collections.reverseOrder());
            }
            else {
                Collections.sort(diag);
            }
        }

        Map<Integer, Integer> pointers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int index = pointers.getOrDefault(key, 0);
                grid[i][j] = map.get(key).get(index);
                pointers.put(key, index + 1);
            }
        }

        return grid;
    }
}
