class Solution {
    boolean isPalindrome(String s, int i, int j){
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        boolean magic = true;
        while (i<=j){
            if ((s.charAt(i)!=s.charAt(j)) && magic){
                magic = false;
                return isPalindrome(s, i+1, j)||isPalindrome(s, i, j-1);
            }else if(s.charAt(i)!=s.charAt(j)&&!magic){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}