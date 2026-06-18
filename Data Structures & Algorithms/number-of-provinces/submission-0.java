

class Solution {
    void f(int node, int[] vis, List<List<Integer>> temp){
        vis[node] = 1;
        for(int i: temp.get(node)){
            if(vis[i]==0){
                f(i, vis, temp);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> res = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isConnected[i][j]==1&&i!=j){
                    res.get(i).add(j);
                }

            }

        }
        int count = 0;
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if(vis[i] == 0){
                count++;
                f(i, vis, res);
            }

        }
        return count;

    }
}