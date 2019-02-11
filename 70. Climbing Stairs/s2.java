class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dfs(0, n, memo);
    }

    public int dfs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0)
            return memo[i];
        memo[i] = dfs(i + 1, n, memo) + dfs(i + 2, n, memo);
        return memo[i];
    }
}
// O(n) size of tree goes up to n
// O(n)
