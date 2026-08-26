import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class pair{
        int node;
        int time;

        public pair(int node, int time) {
            this.node = node;
            this.time = time;
        }

       
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i: times){
            int from = i[0];
            int node = i[1];
            int time = i[2];
            adj.get(from).add(new pair(node, time));
        }
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        PriorityQueue<pair> q = new PriorityQueue<>((a,b)-> a.time-b.time);
        q.add(new pair(k, 0));
        time[0] = 1;
        time[k] = 0;
        while (!q.isEmpty()){
            pair top = q.poll();
            int node = top.node;
            int hrs = top.time;
            for(pair p: adj.get(node)){
                int newNode = p.node;
                int newTime = hrs + p.time;
                if (newTime<time[newNode]){
                    time[newNode] = newTime;
                    q.add(new pair(newNode, newTime));
                }
            }
        }
        int res = Integer.MIN_VALUE;

        for(int i: time){
            if (i==Integer.MAX_VALUE){
                return -1;
            }
            res =  Math.max(res, i);
        }
        return res;
    }
}