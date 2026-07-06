class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long actSum = 0;
        long actSqSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actSum = actSum + nums[i];
            actSqSum = actSqSum + ((long) nums[i] *nums[i]);
        }
        long sum = (long)n*(n+1)/2;
        long sqSum = n*(n+1)*(2L *n+1)/6;

        long diff = actSum-sum;
        long sqDiff = actSqSum- sqSum;

        long add = sqDiff/diff;

        long rep = (add+diff)/2;
        long miss = (add-diff)/2;

        return new int[]{(int)rep, (int)miss};

    }
}