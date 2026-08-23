import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int start = lower;
        int end = upper;
        List<List<Integer>> res = new ArrayList<>();
        if (nums[nums.length-1]<lower){
            res.add(Arrays.asList(start, end));
            return res;
        }
        for (int i: nums){
            if (i<start){
                continue;
            }
            if (i>end){
                break;
            }
            if (i>start&&i<=end){
                res.add(Arrays.asList(start, i-1));
            }
            start = Math.max(start, i+1);
        }
        if (start<=end){
            res.add(Arrays.asList(start, end));
        }
        return res;
    }
}