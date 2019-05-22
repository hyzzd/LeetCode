class Knapsack {
    // NP complete
    // weights needs overlap, otherwise degrade to search O(2 ^ n)
    public int knapsack(int[] w, int[] v) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }
        return max(dp[N]);
    }

    public int knapsack01(int w, int v) {
        for (int j = W; j >= w; j--) {
            dp[j] = Math.max(dp[j], dp[j - w] + v);
        }
        return dp;
    }

    public int solve() {
        for (int i = 1; i <= N; i++) {
            knapsack01(w[i], v[i]);
        }
        return Math.max(dp[N]);
    }

    // iterate j in reverse order to prevent using i-th item multiple times
    // iterate j in normal order for unbounded knapsack
}