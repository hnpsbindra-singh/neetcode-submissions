class Solution {
    static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = i+1; j < matrix[0].length;j++) {
                swap(matrix,i, j, j, i);
            }
        }

        for (int[] ar: matrix){
            reverse(ar);

        }

    }

    private int[] reverse(int[] ar) {
        for (int i = 0; i < ar.length/2; i++) {
            int temp = ar[i];
            ar[i] = ar[ar.length-i-1];
            ar[ar.length-i-1] = temp;
        }
        return ar;

    }
}