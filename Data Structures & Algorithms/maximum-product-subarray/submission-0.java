class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(prod==0) prod=1;
            prod = prod*nums[i];
            max = Math.max(max, prod);
        }
        prod=1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (prod==0) prod=1;
            prod = prod*nums[i];
            max = Math.max(max, prod);
        }
        return max;

    }
}
