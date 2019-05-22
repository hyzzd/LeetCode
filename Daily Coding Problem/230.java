import java.util.*;

class Main {
    public static int eggDrop(int n, int k) {
        if (n == 0 || n == 1 || k == 1)
            return n;

        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 1; i <= n; i++) {
            // 1. egg break at n 2. egg not break
            res = Math.max(eggDrop(i - 1, k - 1), eggDrop(n - i, k));
            if (res < min)
                min = res;
        }

        return min + 1;
    }

    public static int eggDropDP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        int res = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    res = Math.max(dp[x - 1][j - 1], dp[i - x][j]) + 1;
                    if (res < dp[i][j]) {
                        dp[i][j] = res;
                    }
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(eggDropDP(20, 2));
        System.out.println(eggDropDP(15, 3));
    }
}