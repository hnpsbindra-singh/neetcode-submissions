
class Solution {
    boolean isPalindrome(StringBuilder s, int i, int j){
        while(i<j){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    void f(int i, String s, List<List<String>> res , List<String> temp){
        if(i==s.length()){
            res.add(new ArrayList<>(temp));
        }
        StringBuilder x = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            x.append(s.charAt(j));
            if(isPalindrome(x, 0, x.length()-1)){
                temp.add(x.toString());
                f(j+1, s, res, temp);
                temp.remove(temp.size()-1);
            }

        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        f(0, s, res, new ArrayList<>());
        return res;


    }
}
