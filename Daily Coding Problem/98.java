class Main {
    public boolean exist(char[][] board, String word){
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)) return exist(board, word, visited, i, j, 0);
            }
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, String word, boolean[][] visited, int i, int j, int idx){
        if(idx == word.length()) return true;
        int Row = board.length;
        int Col = board[0].length;
        if(i < 0 || i > Row || j < 0 || j > Col || visited[i][j] || board[i][j] != word.charAt(idx)) return false;
        visited[i][j] = true;
        boolean left = exist(board, word, visited, i - 1, j, idx + 1);
        boolean right = exist(board, word, visited, i + 1, j, idx + 1);
        boolean up = exist(board, word, visited, i, j - 1, idx + 1);
        boolean down = exist(board, word, visited, i, j + 1, idx + 1);
        boolean success = left || right || up || down;
        if(!success){
            visited[i][j] = false;
        }
        return success;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}