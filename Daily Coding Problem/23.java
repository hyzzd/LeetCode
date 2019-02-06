class Main {
    public int minStep(int[][] maze) {
        if (maze == null || maze[0] == null)
            return -1;

        mark(maze, 3, 0, 0);

        return maze[0][0];
    }

    private void mark(int[][] maze, int i, int j, int n) {
        int[] neighX = new int[] { 1, -1, 0, 0 };
        int[] neighY = new int[] { 0, 0, -1, 1 };
        boolean[] ok = new boolean[neighX.length];

        for (int k = 0; k < neighX.length; ++k) {
            ok[k] = markP(maze, i + neighX[k], j + neighY[k], n + 1);
        }

        for (int k = 0; k < neighX.length; ++k) {
            if (ok[k]) {
                mark(maze, i + neighX[k], j + neighY[k], n + 1);
            }
        }
    }

    private boolean markP(int[][] maze, int i, int j, int n) {
        if (i >= maze.length || j >= maze[0].length || i < 0 || j < 0 || maze[i][j] != 0) {
            return false;
        }

        maze[i][j] = n;
        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[][] matrix = new int[][] { { 0, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        System.out.println(m.minStep(matrix));
    }
}