

class Solution {
 /*   int f(String s, String t, int i, int j){
        if(i<0||j<0) return 0;
        if (s.charAt(i)==t.charAt(j)) return 1+ f(s,t, i-1, j-1);
        return Math.max(f(s,t, i-1, j), f(s,t,i, j-1));
    }*/
   /* int memo(String s, String t, int i, int j, int[][] dp){
        if(i<0||j<0) return dp[0][0] = 0;
        if(dp[i+1][j+1]!=-1) return dp[i+1][j+1];
        if (s.charAt(i)==t.charAt(j)) return dp[i+1][j+1] = 1+ memo(s,t, i-1, j-1, dp);
        return dp[i+1][j+1] = Math.max(memo(s,t, i-1, j, dp), memo(s,t,i, j-1, dp));
    }*/
    public int longestCommonSubsequence(String s, String t) {

        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i<= s.length(); i++) {
            for (int j = 1; j <= t.length() ; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        return dp[s.length()][t.length()];
    }
}