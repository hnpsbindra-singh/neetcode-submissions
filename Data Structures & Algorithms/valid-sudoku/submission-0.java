
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<Integer, HashSet<Character>> box = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c=='.'){
                    continue;
                }
                int boxIndex = (i/3)*3 + (j/3);
                row.putIfAbsent(i, new HashSet<>());
                col.putIfAbsent(j, new HashSet<>());
                box.putIfAbsent(boxIndex, new HashSet<>());
                if (row.get(i).contains(c) ||
                        col.get(j).contains(c) ||
                        box.get(boxIndex).contains(c)){
                    return false;
                }
                row.get(i).add(c);
                col.get(j).add(c);
                box.get(boxIndex).add(c);
            }
        }
        return true;
    }
}