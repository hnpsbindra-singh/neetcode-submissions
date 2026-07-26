

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
               int sum = nums[i]+nums[j]+nums[k];
               if (sum<0){
                   j++;
               }else if (sum>0){
                   k--;
                }else {
                   res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                   j++;
                   k--;
                   while (j<k&&nums[j-1]==nums[j]) j++;
                   while (j<k&&nums[k+1]==nums[k]) k--;
                }
            }

        }
        return res;
    }
}