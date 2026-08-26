

class Solution {
    class pair{
        int node;
        int cost;

        public pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    class tuple{
        int node;
        int cost;
        int stops;

        public tuple(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i: flights) {
            int from = i[0];
            int to = i[1];
            int cost = i[2];
            adj.get(from).add(new pair(to, cost));
        }
        Queue<tuple> q = new LinkedList<>();
        Integer[] dist = new Integer[n];
        q.add(new tuple(src, 0, 0));
        dist[src] = 0;

        while (!q.isEmpty()){
            tuple top = q.poll();
            int node = top.node;
            int cost = top.cost;
            int stops = top.stops;
            if (stops>k){
                continue;
            }
            for (pair p: adj.get(node)) {
                int newCost = cost+p.cost;
                int newNode = p.node;
                int newStops = stops+1;
                if (dist[newNode]==null||dist[newNode]>newCost){
                    dist[newNode] = newCost;
                    q.add(new tuple(newNode, newCost, newStops));
                }
            }
        }
        if (dist[dst]==null){
            return -1;
        }
        return dist[dst];
    }

}
