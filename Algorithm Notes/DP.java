class DP {
    private final int m = 10;
    private final int n = 10;

    // dp needs the subproblem to be solved first
    public int dp() {
        int[][] dp = new int[m][n]; // create dp array, add padding if needed
        dp[0] = 1; // initialize dp array for base cases

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1]; // transition
            }
        }

        return dp[m - 1][n - 1];
    }

    int[][] memo = new int[m][n];

    // recursion doesn't need the solved subproblem first
    public int recursion(int i, int j) {
        if (i == j) // base case
            return 0;
        if (memo[i][j] == 0)
            memo[i][j] = 1; // transition

        return memo[i][j];
    }
}
