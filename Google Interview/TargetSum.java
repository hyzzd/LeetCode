class TargetSum {
    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) >>> 1);
    }

    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }

    public static void main(String args[]) {
        TargetSum m = new TargetSum();
        int[] nums = new int[] { 1, 1, 1, 1, 1 };
        System.out.print(m.findTargetSumWays(nums, 3));
    }
}