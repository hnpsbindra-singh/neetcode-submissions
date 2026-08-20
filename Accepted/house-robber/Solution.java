class Solution {
    int f(int[] nums, int i, Integer[] dp){
        if (i<0){
            return 0;
        }
        if(i==0){
            return nums[i];
        }
        if (dp[i+1]!=null){
            return dp[i+1];
        }
        int notTake = f(nums, i-1, dp);
        int take = nums[i]+f(nums, i-2, dp);
        return dp[i+1] = Math.max(notTake, take);
    }
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length+1];
        
        return f(nums, nums.length-1, dp);

    }
}