class Main {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, 0, word))
                        return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, int i, int j, int idx, String word) {
        if (idx == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;

        char c = board[i][j];
        board[i][j] = '*';
        boolean res = helper(board, i + 1, j, idx + 1, word) || helper(board, i, j + 1, idx + 1, word);
        board[i][j] = c;

        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'F', 'A', 'C', 'I' }, { 'O', 'B', 'Q', 'P' }, { 'A', 'N', 'O', 'B' },
                { 'M', 'A', 'S', 'S' } };
        Main m = new Main();

        System.out.println(m.exist(board, "FOAM"));
        System.out.println(m.exist(board, "MASS"));
    }
}