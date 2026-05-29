class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }

            set.clear();

            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                else set.add(board[j][i]);
            }

            set.clear();
        }

        int [][] pos = {{0,0}, {0,1}, {0,2},
                        {1,0}, {1,1}, {1,2},
                        {2,0}, {2,1}, {2,2}};

        int [][] points = { {0,0}, {0,3}, {0,6},
                            {3,0}, {3,3}, {3,6},
                            {6,0}, {6,3}, {6,6} };
        
        for (int[] s : points){
            for (int[] p : pos){
                char c = board[s[0]+p[0]][s[1]+ p[1]];
                if (c == '.') continue;
                if (set.contains(c)) return false;
                else set.add(c);
            }
            set.clear();
        }
        
        return true;
    }
}
