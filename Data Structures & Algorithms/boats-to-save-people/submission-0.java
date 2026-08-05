
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int start = 0;
        int end = people.length-1;
        Arrays.sort(people);
        int tot = 0;
        while (start<=end){
            int sum = people[start]+people[end];
            if (sum<=limit){
                tot++;
                start++;
                end--;
            }else {
                tot++;
                end--;
            }
        }
        System.gc();
        return tot;
    }
}