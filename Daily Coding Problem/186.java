import java.util.*;

class Main {
    public static boolean minPartition(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        int n = arr.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = sum; j > 0; j--) {
                if (j >= num) {
                    dp[j] = (dp[j] || dp[j - num]);
                }
            }
        }
        
        return dp[sum];
    }

    public static void main(String[] args) {
        // List<List<Integer>> res = minDist(new int[] { 5, 10, 15, 5, 25 });
        // for (List<Integer> list : res) {
        //     for (Integer l : list) {
        //         System.out.print(l);
        //     }
        //     System.out.println();
        // }
        System.out.println(minPartition(new int[] { 5, 10, 15, 20, 25 }));
    }
}