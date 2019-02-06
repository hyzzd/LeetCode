class Main {
    public int minCost(int[][] matrix) {
        if (matrix == null || matrix[0] == null)
            return -1;

        int row = matrix.length;
        int col = matrix[0].length;
        // row > 2, col > 2
        for (int i = 1; i < row; ++i) {
            matrix[i][0] += Math.min(matrix[i - 1][1], matrix[i - 1][col - 1]);
            for (int j = 1; j < col - 1; ++j) {
                matrix[i][j] += Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]);
            }
            matrix[i][col - 1] += Math.min(matrix[i - 1][0], matrix[i - 1][col - 2]);
        }

        int result = Integer.MIN_VALUE;
        for (int j = 0; j < col; ++j) {
            if (matrix[row - 1][j] > result) {
                result = matrix[row - 1][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}