class Solution {
    int recc(String s, String t, int i, int j, Integer[][] dp){
        if (i<0){
            return j+1;
        }
        if (j<0){
            return i+1;
        }
        if (dp[i][j]!=null){
            return dp[i][j];
        }
        if (s.charAt(i)==t.charAt(j)){
            return recc(s, t, i-1, j-1, dp);
        }
        int delete = recc(s, t, i-1, j, dp);
        int insert = recc(s, t, i, j-1, dp);
        int replace = recc(s, t, i-1, j-1, dp);
        return dp[i][j] = 1+Math.min(delete, Math.min(insert, replace));
    }
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <=word1.length() ; i++) {
            for (int j = 1; j <=word2.length() ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                int delete = dp[i-1][j];
                int insert = dp[i][j-1];
                int replace = dp[i-1][j-1];
                dp[i][j] = 1+Math.min(delete, Math.min(insert, replace));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
