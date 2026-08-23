class Solution {
    public boolean isPalindromic(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i:chars) {
            String bits = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            sb.append(bits);
        }
        return isPalindrome(sb.toString());
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;
        while (start<=end){
            if (str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}