class Main {
    public static boolean canEnd(int[] arr) {
        boolean[] dp = new boolean[arr.length];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            int step = arr[i];
            for (int j = 1; j <= step && i + j < dp.length; j++) {
                dp[i + j] = dp[i];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 3, 1, 2, 0, 1 };
        int[] arr2 = new int[] { 1, 2, 1, 0, 0 };
        System.out.println(canEnd(arr1));
        System.out.println(canEnd(arr2));
    }
}