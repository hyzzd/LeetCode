class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] direction = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int color = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        while (!q.isEmpty()) {
            int[] i = q.remove();
            int r = i[0];
            int c = i[1];
            visited[r][c] = true;
            for (int[] in : direction) {
                int nr = r + in[0];
                int nc = c + in[1];
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && (!visited[nr][nc])
                        && image[nr][nc] == color) {
                    q.add(new int[] { nr, nc });
                }
            }
            image[r][c] = newColor;
        }
        return image;
    }
}
// BFS
