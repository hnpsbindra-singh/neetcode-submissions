
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int sizeA = s1.length();
        int sizeB = s2.length();
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for (int i = 0; i < sizeA; i++) {
            mapA.put(s1.charAt(i), mapA.getOrDefault(s1.charAt(i), 0)+1);
        }
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            mapB.put(s2.charAt(right), mapB.getOrDefault(s2.charAt(right), 0)+1);
            while (right-left+1>sizeA){
                mapB.put(s2.charAt(left), mapB.get(s2.charAt(left))-1);
                if (mapB.get(s2.charAt(left)) == 0) {
                    mapB.remove(s2.charAt(left));
                }
                left++;
            }
            if (right-left+1==sizeA&&mapB.equals(mapA)){
                return true;
            }
        }
        return false;
    }
}