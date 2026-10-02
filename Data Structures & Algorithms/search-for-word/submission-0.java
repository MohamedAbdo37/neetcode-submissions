class Solution {
    private Set<String> taken;
    private StringBuilder word;
    private char[][] board;
    private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        this.taken = new HashSet<>();
        this.board = board;

        this.word = new StringBuilder(word);

        return this.backtrack(0, 0, 0);
    }

    private boolean backtrack(int x, int y, int index) {

        if (!this.isValidX(x) || !this.isValidY(y))
            return false;

        if (this.word.length() == index)
            return true;

        if (this.board[y][x] == this.word.charAt(index)
                && this.pathBacktrack(x, y, index))
            return true;

        boolean result;

        if (x + 1 < this.board[0].length)
            result = backtrack(x + 1, y, index);
        else if (y + 1 < this.board.length)
            result = backtrack(0, y + 1, index);
        else
            return false;

        return result;
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
