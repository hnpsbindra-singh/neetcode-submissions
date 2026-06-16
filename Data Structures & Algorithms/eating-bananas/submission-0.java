class Solution {
    int hours(int[] arr, int mid){
        int time = 0;

        for (int i = 0; i < arr.length; i++) {
            time = (int) (time + Math.ceil((double) arr[i]/mid));
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        int ans = end;
        for (int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }
        while (start<=end){
            int mid = (start+end)/2;
            int req = hours(piles, mid);
            if(req<=h){
                ans = mid;
                end = mid-1;
            }
            else {
                start= mid+1;
            }

        }


        return ans;

    }
}
