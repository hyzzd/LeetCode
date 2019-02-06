class Main {
    private static int isKpalDP(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n] / 2;
    }

    public static int isKpal(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return isKpalDP(str, rev, str.length(), str.length());
    }

    public static void main(String[] args) {
        String str = "acdcb";
        System.out.println(isKpal(str));
    }
}