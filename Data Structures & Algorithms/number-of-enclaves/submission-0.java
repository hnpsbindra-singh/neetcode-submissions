
class Solution {
    class tuple{
        int r;
        int c;

        public tuple(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<tuple> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0]==1){
                vis[i][0] = 1;
                q.add(new tuple(i, 0));
            }
            if (grid[i][m-1]==1){
                vis[i][m-1]=1;
                q.add(new tuple(i, m-1));
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i]==1){
                vis[0][i] = 1;
                q.add(new tuple(0, i));
            }
            if (grid[n-1][i]==1){
                vis[n-1][i] = 1;
                q.add(new tuple(n-1, i));
            }
        }
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0,0, 1, -1};
        while (!q.isEmpty()){
            tuple top = q.poll();
            int r = top.r;
            int c = top.c;
            for (int i = 0; i < dr.length; i++) {
                int nr = r+dr[i];
                int nc = c + dc[i];
                if (nr<0||nc<0||nr>=n||nc>=m||vis[nr][nc]==1||grid[nr][nc]!=1){
                    continue;
                }
                else if (vis[nr][nc]==0&&grid[nr][nc]==1){
                    vis[nr][nc]  = 1;
                    q.add(new tuple(nr, nc));
                }
            }

        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]!=1&&grid[i][j]==1){
                    max++;
                }
            }

        }
        return max;
    }
}