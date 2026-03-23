package graph;

import java.util.*;

public class shortestPath_Dijsktra {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Integer> answer = new ArrayList<>();
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 0; i <= n; i++) parent[i] = i;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        pq.add(new long[]{0L, 1});

        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            long wt = node[0];
            int u = (int) node[1];

            if (wt > dist[u]) continue;

            for (int[] neighbour : adj.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];

                if (wt + w < dist[v]) {
                    dist[v] = wt + w;
                    pq.add(new long[]{dist[v], v});
                    parent[v] = u;
                }
            }
        }

        if (dist[n] == Long.MAX_VALUE) {
            return new ArrayList<>(List.of(-1));
        }

        int node = n;
        while (parent[node] != node) {
            answer.add(node);
            node = parent[node];
        }
        answer.add(1);
        Collections.reverse(answer);

        answer.add(0, (int) dist[n]);
        return answer;
    }
}
