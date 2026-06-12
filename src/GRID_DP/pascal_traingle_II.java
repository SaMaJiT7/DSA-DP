package GRID_DP;

import java.util.ArrayList;
import java.util.List;

public class pascal_traingle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int n = rowIndex;
        long val = 1;
        for(int i = 0; i <= rowIndex; i++){
            ans.add((int)val);
            val = val * (n - i) / (i + 1);
        }
        return ans;
    }
}
