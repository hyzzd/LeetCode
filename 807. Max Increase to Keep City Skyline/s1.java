class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMax = new int[N];
        int[] colMax = new int[N];

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                rowMax[r] = Math.max(rowMax[r], grid[r][c]);
                colMax[c] = Math.max(colMax[c], grid[r][c]);
            }
        }
        int ans = 0;
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                ans += Math.min(rowMax[r], colMax[c]) - grid[r][c];
            }
        }
        return ans;
    }
}
// O(N^2)
// O(N)
