

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int low = intervals[0][0];
        int high = intervals[0][1];
        for (int i[]: intervals) {
            if(i[0]<=high){
                high = Math.max(high, i[1]);
            }
            else {
                res.add(new int[]{low, high});
                low= i[0];
                high = i[1];
            }

        }
        res.add(new int[]{low, high});
        int[][] arr = new int[res.size()][];

        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;

    }
}
