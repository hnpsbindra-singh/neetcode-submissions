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
    public int[][] floodFill(int[][] image, int sr,
                             int sc, int color) {
        if (image[sr][sc]==color){
            return image;
        }
        Queue<pair> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        q.add(new pair(sr, sc));
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while (!q.isEmpty()){
            pair top = q.poll();
            int r = top.r;
            int c = top.c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr<0||nr>= image.length||nc<0||nc>=image[0].length||image[nr][nc]!=oldColor){
                    continue;
                }
                image[nr][nc] = color;
                q.add(new pair(nr, nc));
            }

        }

        return image;
    }
}