
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i: set) {
            if(!set.contains(i-1)) {
                int length = 1;
                while (set.contains(i + length)) {
                    length++;
                }
                max = Math.max(length, max);
            }
        }

        return max;
    }
}