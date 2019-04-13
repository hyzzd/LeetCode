class Main {
    public static int profit(int[] arr, int fee) {
        int[][] dp = new int[arr.length + 1][arr.length + 1]; // [)
        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = arr[i - 1];
        }
        for (int len = 1; len <= arr.length; len++) {
            for (int i = 0; i < arr.length - len + 1; i++) {
                int j = i + len;
                int max = arr[j - 1] - arr[i];
                for (int k = i; k < j - 1; k++) {
                    max = Math.max(max, arr[j - 1] - arr[k] + arr[k] - arr[i] - 2 * fee);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][arr.length];
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 3, 2, 8, 4, 10 };
        System.out.println(profit(a, 2));
    }
}