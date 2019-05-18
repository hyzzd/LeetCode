import java.util.*;

class Main {
    class TireNode {
        TireNode[] next = new TireNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TireNode root = buildTire(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, TireNode node, int i, int j, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null)
            return;

        node = node.next[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0)
            dfs(board, node, i - 1, j, res);
        if (j > 0)
            dfs(board, node, i, j - 1, res);
        if (i < board.length - 1)
            dfs(board, node, i + 1, j, res);
        if (j < board[0].length - 1)
            dfs(board, node, i, j + 1, res);
        board[i][j] = c;
    }

    public TireNode buildTire(String[] words) {
        TireNode root = new TireNode();
        for (String word : words) {
            TireNode t = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (t.next[i] == null)
                    t.next[i] = new TireNode();
                t = t.next[i];
            }
            t.word = word;
        }
        return root;
    }
}