class Solution {

      /*  int f(int i, int amount, int[] nums){
            if(i==0){
                if (amount%nums[i]==0) return 1;
                return 0;
            }
            int not = f(i-1, amount, nums);
            int take = 0;
            if (amount>=nums[i]){
                take = f(i, amount-nums[i], nums);
            }
            return not+take;
        }
        */
    /*int f(int i, int amount, int[] nums, int[][] dp){
        if(i==0){
            if (amount%nums[i]==0) return 1;
            return 0;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int not = f(i-1, amount, nums, dp);
        int take = 0;
        if (amount>=nums[i]){
            take = f(i, amount-nums[i], nums, dp);
        }
        return dp[i][amount] = not+take;
    }*/
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i <=amount ; i++) {
            if (i%coins[0]==0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <=amount ; j++) {
                int not = dp[i-1][j];
                int take = 0;
                if (j>=coins[i]){
                    take = dp[i][j-coins[i]];
                }
                dp[i][j]  = take+not;
            }

        }


        return dp[coins.length-1][amount];
    }
}