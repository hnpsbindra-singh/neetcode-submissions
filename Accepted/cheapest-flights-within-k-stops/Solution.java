import java.util.*;

class Solution {
    class pair{
        int city;
        int cost;
        int stop;

        public pair(int city, int cost, int stop) {
            this.city = city;
            this.cost = cost;
            this.stop = stop;
        }
    }
    class tuple{
        int to;
        int cost;

        public tuple(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<tuple>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i: flights ) {
            int from = i[0];
            int to = i[1];
            int cost = i[2];
            adj.get(from).add(new tuple(to, cost));
        }

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(src, 0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while (!q.isEmpty()){
            pair top = q.poll();
            int city = top.city;
            int cost = top.cost;
            int stop = top.stop;
            if (stop>k){
                continue;
            }
            for (tuple t : adj.get(city)) {
                int to = t.to;
                int toCost = t.cost;
                int newCost = cost+toCost;
                if (newCost<dist[to]){
                    q.add(new pair(to, newCost, stop+1));
                    dist[to] = newCost;
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];

    }
}