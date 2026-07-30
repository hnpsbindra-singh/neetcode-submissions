

class Solution {
    public int splitArray(int[] arr, int k)  {
        if (arr.length<k) return -1;
        long start = Arrays.stream(arr).max().getAsInt();
        long end = 0;
        for (int x : arr) {
            end += x;
        }
        long ans = -1;
        while (start<=end){
            long mid = (start +end)/2;
            if (f(arr, mid)<=k){
                ans = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return (int)ans;
    }

    private int f(int[] arr, long sum) {
        int nSub=1;
        long tot = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tot+arr[i]<=sum){
                tot = tot+arr[i];
            }else {
                nSub++;
                tot = arr[i];
            }
        }
        return nSub;
    }
}