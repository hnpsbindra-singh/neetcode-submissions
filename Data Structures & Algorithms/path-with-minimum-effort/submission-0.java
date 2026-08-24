

class Solution {
    class pair{
        int r;
        int c;
        int effort;

        public pair(int r, int c, int effort) {
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<pair> q = new PriorityQueue<>((a, b)-> a.effort-b.effort);
        int[][] dis = new int[heights.length][heights[0].length];
        q.add(new pair(0,0,0));
        for (int[] i: dis) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        int[] dr = {1, -1, 0,0};
        int[] dc = {0,0,1,-1};
        while (!q.isEmpty()){
            pair top = q.poll();
            int r = top.r;
            int c = top.c;
            int effort = top.effort;
            if(effort>dis[r][c]){
                continue;
            }
            if (r == heights.length-1 && c ==heights[0].length-1){
                return effort;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr<0||nc<0||nr>=heights.length||nc>=heights[0].length){
                    continue;
                }
                int newEffort = Math.max(effort, Math.abs(heights[r][c]-heights[nr][nc]));
                if (newEffort<dis[nr][nc]){
                    dis[nr][nc] = newEffort;
                    q.add(new pair(nr, nc, newEffort));
                }
            }
        }
        return -1;
    }
}