import java.util.HashMap;

class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (mapS.containsKey(ch)){
                mapS.put(ch, mapS.get(ch)-1);
                if (mapS.get(ch)==0){
                    mapS.remove(ch);
                }
            }else{
                res++;
            }
        }
        return res;
    }
}