class Solution {
    
    /*int recc(int i, int j, int[][] grid) {
        if (i == 0 && j == 0)
            return grid[0][0];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if (i > 0)
            up = grid[i][j] + f(i - 1, j, grid);

        if (j > 0)
            left = grid[i][j] + f(i, j - 1, grid);

        return Math.min(up, left);
    }*/
    
    /*int memo(int i, int j, int[][] grid, int[][] dp){
        if(i==0&&j==0){
            return dp[i][j] = grid[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int up = 0;
        int down = 0;
        if(i>0){
            up = grid[i][j] + memo(i-1,j,grid, dp);
        }else {
            up = 69696;
        }
        if(j>0){
            down = grid[i][j] + memo(i, j-1, grid, dp);
        }
        else {
            down = 69696;
        }
        return dp[i][j] = Math.min(up, down);
    }*/

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i==0&&j==0){
                    dp[i][j] = grid[i][j];
                }
                else {
                    int up = 0;
                    int down = 0;
                    if(i>0){
                        up = grid[i][j] + dp[i-1][j];
                    }else {
                        up = 69696;
                    }
                    if(j>0){
                        down = grid[i][j] + dp[i][j-1];
                    }
                    else {
                        down = 69696;
                    }
                    dp[i][j] = Math.min(up, down);
                }
            }
            
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}