package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class restore_finishing {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        int m = friends.length;
        int[] ans = new int[m];
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();

        for(int i = 0; i < m; i++){
            map.add(friends[i]);
        }
        for(int i = 0; i < n; i++){
            if(map.contains(order[i])){
                result.add(order[i]);
            }
        }
        for(int i = 0; i < m; i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}
