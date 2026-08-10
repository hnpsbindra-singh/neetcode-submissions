

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        f(res, board, 0, n);
        return res;

    }

    private void f(List<List<String>> res, char[][] board, int col, int queens) {
        if (col>=queens){
            List<String> list = new ArrayList<>();
            for (char[] i: board) {
                list.add(new String(i));
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < queens; i++) {
            if (isSafe(board, col, i)){
                board[i][col] = 'Q';
                f(res, board, col+1, queens);
                board[i][col] = '.';
            }
        }


    }

    private boolean isSafe(char[][] board, int col, int i) {
        int dupRow = i;
        int dupCol = col;
        while (dupRow>=0&&dupCol>=0){
            if (board[dupRow][dupCol] == 'Q'){
                return false;
            }
            dupCol--;
            dupRow--;
        }
        dupRow = i;
        dupCol = col;
        while (dupCol>=0){
            if (board[dupRow][dupCol] == 'Q'){
                return false;
            }
            dupCol--;
        }
        dupRow = i;
        dupCol = col;
        while (dupRow<board.length&&dupCol>=0){
            if (board[dupRow][dupCol] == 'Q'){
                return false;
            }
            dupCol--;
            dupRow++;
        }

        return true;

    }
}
