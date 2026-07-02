class Solution {
    int f(int[] nums, int i){
        if(i<0) return 0;
        int take = nums[i] + f(nums, i-2);
        int not = f(nums, i-1);
        return Math.max(take, not);
    }

    public int rob(int[] nums) {

        return f(nums, nums.length-1);
    }
}
