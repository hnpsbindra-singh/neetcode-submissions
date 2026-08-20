class Solution {
    public int maxAscendingSum(int[] nums) {
        int left = 0;
        int right = 1;
        int sum = nums[0];
        int maxSum = nums[0];
        while (right< nums.length){
            if (nums[right]>nums[right-1]){
                sum = sum + nums[right];
                maxSum = Math.max(maxSum, sum);
            }else {
                sum = nums[right];
                maxSum = Math.max(sum, maxSum);
            }
            right++;
        }
        return maxSum;
    }
}