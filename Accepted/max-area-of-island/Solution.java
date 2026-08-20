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

    public int maxAreaOfIsland(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (vis[i][j]!=1&&grid[i][j]==1){
                    int area = bfs(i, j, vis, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int i, int j, int[][] vis, int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int area = 0;
        q.add(new pair(i, j));
        vis[i][j] = 1;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()){
            pair top = q.poll();
            int r = top.r;
            int c = top.c;
            area++;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr<0||nr>= grid.length||nc<0||nc>= grid[0].length||vis[nr][nc]==1||grid[nr][nc]==0){
                    continue;
                }
                q.add(new pair(nr, nc));
                vis[nr][nc] = 1;
            }


        }
        return area;
    }
}