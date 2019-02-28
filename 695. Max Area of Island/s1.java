class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == 1)
                    ans = Math.max(ans, area(grid, r, c));
            }
        }
        return ans;
    }

    public int area(int[][] grid, int r, int c) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
            grid[r][c] = 0;
            return (1 + area(grid, r - 1, c) + area(grid, r + 1, c) + area(grid, r, c + 1) + area(grid, r, c - 1));
        }
        return 0;
    }
}
// Depth-first search
// O(rc)
// O(1)
