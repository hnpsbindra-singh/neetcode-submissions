class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        int c = target[0];
        int d = target[1];
        for (int i = 0; i < drones.length; i++) {
            int a = drones[i][0];
            int b = drones[i][1];
            int range = drones[i][2];
            int dist = Math.abs(b-d) + Math.abs(a-c);
            if (dist<=range&&dist<minDistance){
                minDistance = dist;
                minIndex = i;
            }

        }
        return minIndex;
    }
}