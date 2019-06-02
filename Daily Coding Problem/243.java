import java.util.*;

class Main {
    public static int partitionArr(int[] arr, int k) { // n > k
        if (k == 1)
            return sum(arr, 0, arr.length);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum1 = sum(arr, 0, i + 1);
            int sum2 = partitionArr(Arrays.copyOfRange(arr, i + 1, arr.length), k - 1);
            int curMax = Math.max(sum1, sum2);
            if (curMax < min) min = curMax;
        }

        return min;
    }

    public static int sum(int[] arr, int i, int j) {
        int res = 0;
        for (int k = i; k < j; k++)
            res += arr[k];
        return res;
    }

    public static int partitionArr1(int[] arr, int k) { // n > k
        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][1] = sum(arr, 0, i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                int sum1 = sum(arr, 0, i + 1);
                int sum2 = dp[i + 1][j - 1];
                dp[i][j] = Math.min(Integer.MAX_VALUE, Math.max(sum1, sum2));
            }
        }
        
        return dp[0][k];
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 7, 3, 4};
        System.out.println(partitionArr(arr, 3));
        System.out.println(partitionArr1(arr, 3));
    }
}