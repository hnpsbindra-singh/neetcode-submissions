class Solution {
    public int minOperations(String s) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int total = i + cost(i, s);
            res = Math.min(res, total);
        }
        return res;
    }

    private int cost(int i, String s) {
        int start = 0;
        int n = s.length();
        int end = n-1;
        int res = 0;
        while (start<end){
            char lChar = s.charAt((start+i)%n);
            char rChar = s.charAt((end+i)%n);
            int min = Math.abs(lChar-rChar);
            res = res + Math.min(min, 26-min);
            start++;
            end--;
        }
        return res;
    }
}