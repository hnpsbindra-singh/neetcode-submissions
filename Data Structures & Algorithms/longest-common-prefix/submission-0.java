class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i<strs[0].length()&&j<strs[strs.length-1].length()){
            if (strs[0].charAt(i)!=strs[strs.length-1].charAt(j)){
                return sb.toString();
            }
            sb.append(strs[0].charAt(i));
            i++;
            j++;
        }
        return sb.toString();

    }
}