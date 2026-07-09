class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;
        int r = 0;
        int s = 0;
        int min = Integer.MAX_VALUE;
        while (r< nums.length||s>=target){
            if(s>=target){
                min = Math.min(min, r-l);
                s = s-nums[l++];
            }else {
                s = s + nums[r++];
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}