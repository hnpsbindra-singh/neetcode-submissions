

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i: prerequisites) {
            int u = i[0];
            int v = i[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for (int i: adj.get(node)) {
                indegree[i]--;
                if (indegree[i]==0){
                    q.add(i);
                }
            }

        }
        return res.size()==numCourses;
    }
}