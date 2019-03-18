class Main {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int m = matrix.length, n = matrix[0].length;
        int col = 0, row = 0, d = 0;
        int[][] dir = { { -1, 1 }, { 1, -1 } };
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row = row + dir[d][0];
            col = col + dir[d][1];
            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }
            if (row < 0) {
                row = 0;
                d = 1 - d;
            }
            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }
        return res;
    }
}