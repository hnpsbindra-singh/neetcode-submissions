

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(dp,n);

    }

    private int f(int[] dp, int i) {
        if(i==0||i==1){
            return dp[i]=1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=f(dp, i-1) + f(dp, i-2);
    }
}
