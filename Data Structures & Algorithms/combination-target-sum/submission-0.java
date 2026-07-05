
class Solution {
    void f(int[] nums,int i, int target, List<List<Integer>> res , List<Integer> temp){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i== nums.length){
            return;
        }
        if(nums[i]<=target) {
            temp.add(nums[i]);
            f(nums, i, target - nums[i], res, temp);
            temp.remove(temp.size() - 1);
        }

        f(nums, i+1, target, res, temp);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0,target, res, new ArrayList<>());
        return res;
    }
}
