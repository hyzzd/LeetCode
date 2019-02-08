class Main {
    public static int collectCoins(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return -1;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i + 1][j + 1] = matrix[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] coins = new int[][] { { 0, 3, 1, 1 }, { 2, 0, 0, 4 }, { 1, 5, 3, 1 } };
        System.out.print(collectCoins(coins));
    }
}