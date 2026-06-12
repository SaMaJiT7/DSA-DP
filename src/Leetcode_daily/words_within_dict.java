package Leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class words_within_dict {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        int m = dictionary.length;
        List<String> Result = new ArrayList<>();
        for (String wq : queries) {
            for (String wd : dictionary) {
                int i1 = 0;
                int j1 = 0;
                int count = 0;
                while (i1 < wq.length() && j1 < wq.length()) {
                    if (wq.charAt(i1) != wd.charAt(j1)) {
                        count++;
                    }
                    if (count > 2) {
                        break;
                    }
                    i1++;
                    j1++;
                }
                if (count <= 2) {
                    Result.add(wq);
                    break;
                }
            }
        }
        return Result;
    }
}
