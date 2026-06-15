class Solution {
    int f(int[] arr, int mid){
        int ndays = 1;
        int load  = 0;
        for (int i = 0; i < arr.length; i++) {
            if(load+arr[i]>mid){
                load = arr[i];
                ndays++;
            }
            else {
                load=load+arr[i];
            }

        }
        return ndays;

    }
    public int shipWithinDays(int[] weights, int days) {
        int start = weights[0];
        int end = weights[0];
        int ans = -1;
        for (int i = 1; i <weights.length ; i++) {
            start = Math.max(start, weights[i]);
            end = end + weights[i];
        }

        while (start<=end){
            int mid = (start+end)/2;
            int req = f(weights, mid);
            if(req<=days){
                ans = mid;
                end=mid-1;
            }
            else {
                start = mid+1;
            }

        }
        return ans;

    }
}