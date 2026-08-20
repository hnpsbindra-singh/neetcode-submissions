class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < lights.length; i++) {
            maxTime = Math.max(maxTime, lights[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arrivalTime.length; i++) {
            int cycle = arrivalTime[i]%period;
            int total = 0;
            if (cycle>=maxTime){
                total = total + period-cycle;
            }
            res = Math.max(res, total);
        }
        return res;
    }
}