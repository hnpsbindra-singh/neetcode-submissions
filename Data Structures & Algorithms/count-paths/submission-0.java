

class Solution {
    int f(int i, int j, int[][] dp){
        if (i==0&&j==0) return dp[i][j] = 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = 0;
        int down = 0;
        if(i>0) up = f(i-1,j, dp);
        if (j>0) down = f(i, j-1, dp);
        return dp[i][j] = up+down;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] i: dp) {
            Arrays.fill(i, -1);
        }
        
        return f(m-1, n-1, dp);

    }
}
