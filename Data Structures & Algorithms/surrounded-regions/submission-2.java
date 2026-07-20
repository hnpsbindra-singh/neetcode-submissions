

class Solution {
    class tuple{
        int r;
        int c;
        public tuple(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<tuple> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0]=='O'){
                vis[i][0] = 1;
                q.add(new tuple(i,0));
            }
            if (board[i][m-1]=='O'){
                vis[i][m-1] = 1;
                q.add(new tuple(i,m-1));
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i]=='O'){
                vis[0][i] = 1;
                q.add(new tuple(0,i));
            }
            if (board[n-1][i]=='O'){
                vis[n-1][i] = 1;
                q.add(new tuple(m-1,i));
            }
        }

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0, -1, 1};
        while (!q.isEmpty()){
            tuple top = q.poll();
            int r = top.r;
            int c = top.c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr<0||nc<0||nr>=n||nc>=m||vis[nr][nc]==1||board[nr][nc]=='X'){
                    continue;
                }else if(vis[nr][nc]!=1&&board[nr][nc]=='O'){
                    q.add(new tuple(nr, nc));
                    vis[nr][nc]= 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]=='O'&&vis[i][j]==0){
                    board[i][j] = 'X';
                }
            }

        }

    }
}
