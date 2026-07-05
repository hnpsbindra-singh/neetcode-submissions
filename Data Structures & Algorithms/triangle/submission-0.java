
class Solution {
    int f(int i, int j, List<List<Integer>> arr){
        int m = arr.size();
        if(i==m-1) return arr.get(i).get(j);
        int down = arr.get(i).get(j) + f(i+1, j, arr);
        int right = arr.get(i).get(j) + f(i+1, j+1, arr);
        return Math.min(down, right);
    }
    int memo(int i, int j, List<List<Integer>> arr, int[][] dp){
        int m = arr.size();
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==m-1) return dp[i][j] = arr.get(i).get(j);
        int down = arr.get(i).get(j) + memo(i+1, j, arr, dp);
        int right = arr.get(i).get(j) + memo(i+1, j+1, arr, dp);
        return dp[i][j]=Math.min(down, right);
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int m = arr.size();
        int n = arr.get(m-1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = arr.get(m - 1).get(i);
        }
        for (int i = m-2; i >=0 ; i--) {
            for (int j = i; j >=0 ; j--) {
                int down = arr.get(i).get(j) + dp[i+1][j];
                int right = arr.get(i).get(j) + dp[i+1][j+1];
                dp[i][j]=Math.min(down, right);
            }

        }

        return dp[0][0];
    }
}