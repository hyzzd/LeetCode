class Main {
    public static int ways(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            if (matrix[0][i] == 1) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (dp[0] == 0 || matrix[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < dp.length; j++) {
                if (matrix[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.print(ways(new int[][] { { 0, 0, 1 }, { 0, 0, 1 }, { 1, 0, 0 } }));
    }
}