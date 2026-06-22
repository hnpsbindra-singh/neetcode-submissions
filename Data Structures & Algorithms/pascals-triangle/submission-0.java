

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j <i ; j++) {
                int num = res.get(i-1).get(j) + res.get(i-1).get(j-1);
                temp.add(num);
            }
            temp.add(1);
            res.add(temp);
            
        }
        return res;
    }
}