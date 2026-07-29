package graph;

import java.util.*;

public class Bus_Routes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, List<Integer>> busStopThisStation = new HashMap<>();
        if(source == target) return 0;
        int n = routes.length;
        for(int i = 0; i < n; i++){
            int size = routes[i].length;
            for(int j = 0; j < size; j++){
                busStopThisStation.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }
        if (!busStopThisStation.containsKey(source)) return -1;
        HashSet<Integer> stationVisited = new HashSet<>();
        HashSet<Integer> busVisited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int bus = 0;
        queue.add(source);
        stationVisited.add(source);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int currStation = queue.poll();
                if(currStation == target){
                    return bus;
                }
                for(Integer nextBus : busStopThisStation.getOrDefault(currStation,new ArrayList<>())){
                    if(busVisited.contains(nextBus)){
                        continue;
                    }
                    busVisited.add(nextBus);

                    for(int nextStation : routes[nextBus]){
                        if(stationVisited.contains(nextStation)){
                            continue;
                        }
                        queue.add(nextStation);
                        stationVisited.add(nextStation);
                    }
                }
            }
            bus++;
        }
        return -1;
    }
}
