

class Solution {
    class pair{
        int r;
        int c;
        int cost;

        public pair(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    q.add(new pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while (!q.isEmpty()){
            pair top = q.poll();
            int r = top.r;
            int c = top.c;
            int cost = top.cost;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length||grid[nr][nc] == -1||vis[nr][nc]==1) {
                    continue;
                }
                int newCost = cost+1;
                vis[nr][nc] = 1;
                q.add(new pair(nr, nc, newCost));
                grid[nr][nc] = newCost;

            }


        }

    }
}
