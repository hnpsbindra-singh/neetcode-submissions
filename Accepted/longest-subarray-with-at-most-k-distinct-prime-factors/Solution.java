import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> fact = f(nums[i]);
            for (int j: fact) {
                map.put(j, map.getOrDefault(j, 0)+1);
            }
            while (map.size()>k){
                for (int j: f(nums[left])) {
                    map.put(j, map.get(j)-1);
                    if (map.get(j)==0){
                        map.remove(j);
                    }
                }
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
    public List<Integer> f(int i){
        List<Integer> res = new ArrayList<>();
        for (int j = 2; j*j <=i ; j++) {
            if (i%j==0){
                res.add(j);
                while (i%j==0){
                    i = i/j;
                }
            }
        }
        if (i>1){
            res.add(i);
        }
        return res;
    }
}