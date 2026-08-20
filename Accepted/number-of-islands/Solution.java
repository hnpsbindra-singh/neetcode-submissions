import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class pair{
        int r;
        int c;

        public pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] vis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'&&vis[i][j]!=1){
                    bfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int[][] vis, int i, int j) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        vis[i][j] = 1;
        while (!q.isEmpty()){
            pair p = q.poll();
            int r = p.r;
            int c = p.c;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr<0||nr>= grid.length||nc<0||nc>=grid[0].length||vis[nr][nc]==1||grid[nr][nc]=='0'){
                    continue;
                }
                q.add(new pair(nr, nc));
                vis[nr][nc] = 1;
            }
        }
    }
}