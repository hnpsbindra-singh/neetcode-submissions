class Solution {
    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int l = 0;
        for (int i = 0; i < lmax.length ; i++) {
            l = Math.max(l, height[i]);
            lmax[i] = l;

        }
        l = 0;
        int tot = 0;
        for (int i = height.length-1; i >=0 ; i--) {
            l= Math.max(l, height[i]);
            tot = tot + Math.min(lmax[i], l) - height[i];
        }
        return tot;

    }
}