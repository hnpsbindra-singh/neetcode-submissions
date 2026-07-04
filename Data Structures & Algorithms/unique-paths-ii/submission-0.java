

class Solution {
    /*int f(int i, int j, int[][] arr){
        if(arr[i][j]==1) return 0;
        if(i==0&&j==0) return 1;
        int up = 0;
        int left=0;
        if(i>0) up = f(i-1, j, arr);
        if(j>0) left = f(i, j-1, arr);
        return up+left;
    }*/

    /*int memo(int i, int j, int[][] arr, int[][] dp){
        if(arr[i][j]==1) return dp[i][j] = 0;
        if(i==0&&j==0) return dp[i][j] = 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = 0;
        int left=0;
        if(i>0) up = memo(i-1, j, arr, dp);
        if(j>0) left = memo(i, j-1, arr, dp);
        return dp[i][j] = up+left;
    }*/

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==1) {
                    dp[i][j]=0;
                } else if (i==0&&j==0) {
                    dp[i][j] = 1;
                }else {
                    int up = 0;
                    int left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }

            }
            
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
        

    }
}