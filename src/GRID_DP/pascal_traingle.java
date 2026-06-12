package GRID_DP;

import java.util.ArrayList;
import java.util.List;

public class pascal_traingle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> Result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for(int j = 1; j < i; j++){
                now.add(prev.get(j-1) + prev.get(j));
            }
            if(i > 0) now.add(1);
            Result.add(now);
            prev = now;
        }
        return Result;
    }
}
