class Solution {
    void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public void reverseString(char[] s) {
        int n = s.length/2;
        for (int i = 0; i < n; i++) {
            swap(s, i, s.length-i-1);

        }

    }
}