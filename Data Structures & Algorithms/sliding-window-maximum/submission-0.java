
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int j = 0;
        ArrayDeque<Integer> max = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!max.isEmpty()&&nums[max.peekLast()]<=nums[i]){
                max.pollLast();
            }
            while (!max.isEmpty()&&max.peekFirst()<=i-k){
                max.pollFirst();
            }
            max.add(i);
            if (i>=k-1){
                res[j] = nums[max.peekFirst()];
                j++;
            }
        }
        return res;
    }
}