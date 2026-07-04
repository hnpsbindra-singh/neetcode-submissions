
class Solution {
    void f(int i, List<List<Integer>> res, List<Integer> temp, int[] nums){
        if(i>= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        f(i+1, res, temp, nums);
        temp.remove(temp.size()-1);

        int next = i+1;
        while (next< nums.length&&nums[next]==nums[next-1]){
            next++;
        }
        f(next, res, temp, nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        f(0, res, new ArrayList<>(), nums);
        return res;

    }
}
