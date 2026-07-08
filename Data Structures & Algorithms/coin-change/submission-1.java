
class Solution {
    /*int f(int i, int amount, int[] coins) {
        if (i == 0) {
            if (amount % coins[i] == 0) return amount / coins[i];
            return 7000;
        }
        int not = f(i-1, amount, coins);
        int take = 7000;
        if(coins[i]<=amount){
            take = 1+ f(i, amount-coins[i], coins);
        }
        return Math.min(not, take);
    }*/
   /* int f(int i, int amount, int[] coins, int[][] dp) {
        if (i == 0) {
            if (amount % coins[i] == 0) return dp[i][amount] = amount / coins[i];
            return dp[i][amount] = 7000;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int not = f(i-1, amount, coins, dp);
        int take = 7000;
        if(coins[i]<=amount){
            take = 1+ f(i, amount-coins[i], coins, dp);
        }
        return dp[i][amount] = Math.min(not, take);
    }*/
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i <=amount; i++) {
            if(i%coins[0]==0){
                dp[0][i] = i/coins[0];
            }else {
                dp[0][i]= 7000;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <=amount ; j++) {
                int not = dp[i-1][j];
                int take = 7000;
                if(coins[i]<=j){
                    take = 1+ dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(not, take);
            }

        }
        return dp[coins.length - 1][amount] >= 7000
                ? -1
                : dp[coins.length - 1][amount];
    }
}