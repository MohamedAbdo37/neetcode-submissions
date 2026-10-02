class Solution {
    private Set<String> taken;
    private String word;
    private char[][] board;
    private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        this.taken = new HashSet<>();
        this.board = board;

        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.pathBacktrack(j, i, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean isValidX(int x) {
        return !(x < 0 || x >= this.board[0].length);
    }

    private boolean isValidY(int y) {
        return !(y < 0 || y >= this.board.length);
    }

    private boolean pathBacktrack(int x, int y, int index) {

        if (!this.isValidX(x) || !this.isValidY(y))
            return false;

        if (this.board[y][x] == this.word.charAt(index)) {
            if (this.word.length() - index == 1)
                return true;
            this.taken.add("" + x + "," + y);
            for (int[] direction : this.directions) {
                if (this.taken.contains("" + (x + direction[1]) + "," + (y
                        + direction[0]))
                        || !this.isValidX(x + direction[1]) || !this.isValidY(y + direction[0])) {
                    continue;
                }
                if (this.pathBacktrack(x + direction[1], y + direction[0], index + 1)) {
                    return true;
                }
            }
            this.taken.remove("" + x + "," + y);
        }

        return false;
    }
}
