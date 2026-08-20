class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int[] left = new int[n];
        int[] right = new int[n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j<station.length()&&skill.charAt(i)!=station.charAt(j)){
                j++;
            }
            left[i] = j;
            j++;
        }
        j = station.length()-1;
        for (int i = n-1; i >=0; i--) {
            while (j>=0&&skill.charAt(i)!=station.charAt(j)){
                j--;
            }
            right[i] = j;
            j--;
        }

        int ans = 0;
        for (int i = 0; i < skill.length()-1; i++) {
            ans = Math.max(ans, right[i+1]-left[i]);
        }
        return ans;
    }
}