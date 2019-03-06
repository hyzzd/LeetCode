class Main {
    public static int maxProfit(int price[], int k) {
        int n = price.length;
        int profit[][] = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;

        for (int i = 1; i <= k; i++) {
            // profit[t][i] = max(profit[t][i-1], price[i] + max(prevDiff, profit[t-1][i-1]
            // – price[i-1]) where prevDiff is max(profit[t-1][j] – price[j]) for all j in
            // range [0, i-2]
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1], price[j] + prevDiff);
            }
        }

        return profit[k][n - 1];
    }

    public static void main(String[] args) {
        System.out.print(maxProfit(new int[] { 12, 14, 17, 10, 14, 13, 12, 15 }, 3));
    }
}