class Solution {
    int recc(String s, String t, int i, int j){
        if (i<0){
            return j+1;
        }
        if (j<0){
            return i+1;
        }
        if (s.charAt(i)==t.charAt(j)){
            return recc(s, t, i-1, j-1);
        }
        int delete = recc(s, t, i-1, j);
        int insert = recc(s, t, i, j-1);
        int replace = recc(s, t, i-1, j-1);
        return 1+Math.min(delete, Math.min(insert, replace));
    }
    public int minDistance(String word1, String word2) {
        return recc(word1, word2, word1.length()-1, word2.length()-1);
    }
}
