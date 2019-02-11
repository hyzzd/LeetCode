class Solution {
    public int climbStairs(int n) {
        return dfs(0, n);
    }

    public int dfs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return dfs(i + 1, n) + dfs(i + 2, n);
    }
}
// O(2^n)
// O(n) depth
