class Main {
    public static int maxAmount(int[] v) {
        int[][] dp = new int[v.length][v.length];
        for (int len = 0; len < v.length; len++) {
            for (int i = 0, j = len; j < v.length; i++, j++) {
                int a, b, c;
                if (i + 2 <= j) {
                    a = dp[i + 2][j];
                    b = dp[i + 1][j - 1];
                    c = dp[i][j - 2];
                } else {
                    a = 0;
                    b = 0;
                    c = 0;
                }
                dp[i][j] = Math.max(v[i] + Math.min(a, b), v[j] + Math.min(b, c));
            }
        }
        return dp[0][v.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxAmount(new int[] { 1 }));
        System.out.println(maxAmount(new int[] { 1, 2 }));
        System.out.println(maxAmount(new int[] { 1, 2, 3 }));
    }
}