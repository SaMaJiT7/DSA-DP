package Leetcode_daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class closest_Equal {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> Result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i); // storing like {1,{0,2,4}} element with occuring indexes
        }
        int m = queries.length;
        for(int i = 0; i < m; i++){
            int idx = queries[i];
            int ele = nums[idx];

            if(map.get(ele).size() == 1){
                Result.add(-1);
            }
            else{
                int size = map.get(ele).size();
                //Binary Search to find the index in (log size) time.
                int start = 0;
                int end = size-1;
                int pos = -1;
                List<Integer> list = map.get(ele);
                while(start <= end){
                    int mid = start + (end-start)/2;
                    if(list.get(mid) == idx){
                        pos = mid;
                        break;
                    }
                    else if(list.get(mid) > idx){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                // Calculating the next same value index in circular array both side right and left movement.
                int nextidx = list.get((pos + 1) % size);
                int previdx = list.get((pos - 1 + size) % size);

                int d1 = Math.abs(idx - nextidx);
                int distnext = Math.min(d1,n - d1);

                int d3 = Math.abs(idx - previdx);
                int distprev = Math.min(d3,n - d3);

                int ans = Math.min(distnext,distprev);
                Result.add(ans);
            }
        }
        return Result;
    }
}
