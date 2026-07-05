
class Solution {
    void f(int[] nums,int i, List<List<Integer>> res , List<Integer> temp){

        if(i== nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

            temp.add(nums[i]);
            f(nums, i+1, res, temp);
            temp.remove(temp.size() - 1);


        f(nums, i+1, res, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0, res, new ArrayList<>());
        return res;
    }
}
