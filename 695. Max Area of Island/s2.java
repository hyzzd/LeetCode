class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        int[] dr = new int[] { 1, -1, 0, 0 };
        int[] dc = new int[] { 0, 0, -1, 1 };
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == 1 && !seen[r][c]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[] { r, c });
                    seen[r][c] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int rn = node[0], cn = node[1];
                        shape++;
                        for (k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1
                                    && !seen[nr][nc]) {
                                stack.push(new int[] { nr, nc });
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }
}
