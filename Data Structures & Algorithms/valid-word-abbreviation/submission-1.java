class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i< word.length()&&j<abbr.length()){
            if (abbr.charAt(j)=='0'){
                return false;
            }
            if (Character.isLetter(abbr.charAt(j))&&word.charAt(i)==abbr.charAt(j)){
                i++;
                j++;
            }else if(Character.isLetter(abbr.charAt(j))&&word.charAt(i)!=abbr.charAt(j)){
                return false;
            }else if(Character.isDigit(abbr.charAt(j))){
                int num = 0;
                while (j<abbr.length()&&Character.isDigit(abbr.charAt(j))){
                    num = num * 10 + (abbr.charAt(j)-'0');
                    j++;
                }
                if (i+num<=word.length()){
                    i = i+num;
                }else {
                    return false;
                }
            }
        }
        return i==word.length()&&j==abbr.length();
    }
}