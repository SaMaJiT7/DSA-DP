package graph;

import java.sql.PreparedStatement;
import java.util.*;

public class minimum_cost_tostr_two {
    static final long INF = (long) 1e15;
    String source;
    String target;

    TreeSet<Integer> length;

    String[] original;
    String[] changed;
    Map<String, List<Pair>> adj;
    Map<Integer, Long> memo = new HashMap<>();

    Map<String, Map<String, Long>> dijkstraMemo = new HashMap<>();
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        this.adj = new HashMap<>();
        this.length = new TreeSet<>();
        int n = original.length;
        this.source = source;
        this.target = target;
        this.original = original;
        this.changed = changed;
        for(int i = 0; i < n; i++){
            length.add(original[i].length());
            String u = original[i];
            String v = changed[i];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, cost[i]));
        }
        long ans = solve(0);
        return ans >= INF ? -1 : ans;
    }

    public long solve(int i){
        if (source.length() != target.length()) return -1;

        if(i >= source.length()){
            return 0;
        }
        if (memo.containsKey(i)) return memo.get(i);
        long resultcost = INF;
        if(source.charAt(i) == target.charAt(i)){
            resultcost = solve(i+1);
        }
        for(int l : length){
            if(i + l > source.length()){
                break;
            }
            String srcsub = source.substring(i,i+l);
            String targetsub = target.substring(i,i+l);
            if(!adj.containsKey(srcsub)){
                continue;
            }
            long pathcost;
            dijkstraMemo.putIfAbsent(srcsub, new HashMap<>());
            Map<String, Long> inner = dijkstraMemo.get(srcsub);

            if (inner.containsKey(targetsub)) {
                pathcost = inner.get(targetsub);
            } else {
                pathcost = Dijsktra(srcsub, targetsub);
                inner.put(targetsub, pathcost);
            }

            if (pathcost != -1) {
                resultcost = Math.min(resultcost, pathcost + solve(i + l));
            }
        }
        memo.put(i,resultcost);
        return resultcost;
    }

    public long Dijsktra(String src, String tgt) {
        PriorityQueue<Pair> pq =
                new PriorityQueue<>();
        Map<String, Long> dist = new HashMap<>();
        pq.add(new Pair(src, 0));
        dist.put(src, 0L);

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long cost = current.cost;       // Current total distance so far
            String node = current.vertex;

            if (node.equals(tgt)) return cost;

            if (cost > dist.get(node)) continue;

            for(Pair p : adj.getOrDefault(node,new ArrayList<>())){
                String neighbor = p.vertex;
                long c = p.cost;


                long newCost = c + cost;
                if (newCost < dist.getOrDefault(neighbor,INF)) {
                    dist.put(neighbor,newCost);
                    pq.add(new Pair(neighbor, newCost));
                }
            }
        }
        return -1;
    }

    class Pair implements Comparable<Pair> {
        String vertex;
        long cost;


        public Pair(String v, long c) {
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair Other) {
            return Long.compare(this.cost, Other.cost);
        }
    }
}
