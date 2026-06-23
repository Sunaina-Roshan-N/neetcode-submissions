class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!seen.add(board[i][j] + "row" + i) ||
                        !seen.add(board[i][j] + "column" + j) ||
                        !seen.add(board[i][j] + "row" + i/3 + "column" + j/3))
                        return false;
                }
            }
        }

        return true;
    }
}
