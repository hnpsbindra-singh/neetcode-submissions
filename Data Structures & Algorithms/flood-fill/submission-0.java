class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int old = image[sr][sc];
        if (old == color) {
            return image;
        }
        dfs(image, sr, sc, old, color);
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int old, int color) {
        int n = image.length;
        int m = image[0].length;
        if(sr<0||sc>=m||sr>=n||sc<0||image[sr][sc]!=old){
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, old, color);
        dfs(image, sr - 1, sc, old, color);
        dfs(image, sr, sc + 1, old, color);
        dfs(image, sr, sc - 1, old, color);

    }
}