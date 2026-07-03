
class Solution {
    int f(int start, int end, int[] nums, int[] dp){
        if(start>end) return 0;
        if(dp[start]!=-1) return dp[start];
        int not = f(start+1, end, nums, dp);
        int take = nums[start] + f(start+2, end, nums, dp);
        return dp[start] = Math.max(not, take);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int max1 = f(0, nums.length-2, nums, dp1);
        int max2 = f(1, nums.length-1, nums, dp2);
        return Math.max(max1, max2);

    }
}
