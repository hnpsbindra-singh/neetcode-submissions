

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b)-> map.get(a)- map.get(b));
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1 );
        }
        for (int i: map.keySet()){
            min.offer(i);
            if(min.size()>k){
                min.poll();
            }
        }
        int[] res = new int[min.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = min.poll();
        }
        return res;
        
    }
}
