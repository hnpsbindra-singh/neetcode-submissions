/*
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if(sum == k){
                max = Math.max(max, i+1);
            }else {
                if(map.containsKey(sum-k)){
                    max = Math.max(max, i- map.get(sum-k));
                }else {
                    map.put(sum, i);
                }
            }

        }
        return max;

    }
}*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                count++;
            }
            else {
                max = Math.max(max, count);
                count= 0;
            }
            
        }
        max = Math.max(max, count);
        return max;
    }
}
