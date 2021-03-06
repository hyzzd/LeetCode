class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbors = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i >= 1 && grid[i - 1][j] == 1)
                        neighbors++;
                    if (j >= 1 && grid[i][j - 1] == 1)
                        neighbors++;
                }
            }
        }
        return 4 * islands - 2 * neighbors;
    }
}
// O(n^2)
// O(1)
