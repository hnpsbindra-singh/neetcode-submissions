
class Solution {
    int f(int[] nums, int i, int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = nums[i] + f(nums, i-2, dp);
        int not = f(nums, i-1, dp);
        return dp[i] = Math.max(take, not);
    }

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums, nums.length-1, dp);
    }
}
