class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k = (n+m)/2;
        int prev = 0;
        int curr = 0;
        int i = 0;
        int j = 0;
        for (int x = 0; x <= k; x++) {
            prev = curr;
            if(i< nums1.length&&(j>= nums2.length||nums1[i]<=nums2[j])){
                curr = nums1[i++];
            }else {
                curr = nums2[j++];
            }
        }
        if ((n+m)%2==0){
            return (prev+curr)/2.0;
        }
        return curr;
    }
}